package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ChengY
 * @date 2023/4/6 20:53
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String ServerPort;


    @Autowired
    private PaymentService paymentService;


    @PostMapping(value ="/payment/create")
    public CommonResult insertPay(@RequestBody Payment payment){

        int i = paymentService.create(payment);

        if(i>0){
            log.info("插入成功");
            return new CommonResult(200,"成功"+ServerPort,null);
        }else{
            log.info("失败");
            return new CommonResult(444,"失败",null);
        }

    }
   @RequestMapping(value = "/payment/select/{idName}")
    public CommonResult selectById(@PathVariable("idName") Long id){

       Payment paymentById = paymentService.getPaymentById(id);

       if(paymentById!=null){
           return new CommonResult(200,"成功"+ServerPort,paymentById);
       }else{

           return new CommonResult(444,"失败",null);
       }

   }


}
