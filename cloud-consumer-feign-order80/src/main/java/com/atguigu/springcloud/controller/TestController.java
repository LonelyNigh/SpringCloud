package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChengY
 * @date 2023/4/11 9:06
 */
@RestController
public class TestController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping("/feignClient/payment/select/{idName}")
    public CommonResult getPaymentById(@PathVariable("idName") Long id) {


        return paymentFeignService.selectById(id);
    }
}
