package com.atguigu.springclou.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author ChengY
 * @date 2023/4/11 16:19
 */
@Service
public class PaymentService {
    /**
     * 正常访问，肯定没有问题的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池: "+Thread.currentThread().getName() + " paymentInfo_OK,id: " +id+ "\t"+ "^_^";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value = "true"), //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker( Integer id) {
        if (id < 0) {
            throw new RuntimeException("***********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();//等价于UUID.randomUUID().toString()    commons中引入了hutool-all hutool.cn
        return Thread.currentThread().getName()+ "\t"+ "调用成功, 流水号: "+serialNumber;
    }

@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler" ,commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "3000")
})
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 5;
        //暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " +id+ "\t"+ "0_0 耗时: " +timeNumber+ "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "调用支付接口超时或者异常：\t" + "\t当前线程："+Thread.currentThread().getName() + " paymentInfo_TimeOutHandler, id: " +id;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试，id："+id;
    }

}


