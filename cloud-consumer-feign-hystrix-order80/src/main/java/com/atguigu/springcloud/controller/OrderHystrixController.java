package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrdertHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ChengY
 * @date 2023/4/11 16:47
 */
@RestController

public class OrderHystrixController {
 @Autowired
   private OrdertHystrixService ordertHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = ordertHystrixService.paymentInfo_OK(id);
        return result;
    }
    @HystrixCommand(fallbackMethod = "fallbackOutTimeMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = ordertHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String fallbackOutTimeMethod(Integer id){
        return "消费者Consumer调用支付接口超时或者异常：\t" + "\t当前线程："+Thread.currentThread().getName() + " paymentInfo_TimeOutHandler, id: " +id;
    }

}
