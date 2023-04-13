package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author ChengY
 * @date 2023/4/8 11:47
 */
@RestController
@Slf4j
public class PaymentRemoteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/consumer/payment/create")
    public CommonResult<Payment> insertPayment(Payment payment){

        String s = "http://CLOUD-PAYMENT-SERVICE";
        return restTemplate.postForObject(s+"/payment/create",payment,CommonResult.class);

    }


    @GetMapping(value="/consumer/payment/select/{idName}")
    public CommonResult<Payment> getPayment(@PathVariable("idName") Long id){
        String s = "http://CLOUD-PAYMENT-SERVICE";
        return restTemplate.getForObject(s+"/payment/select/"+id,CommonResult.class);
    }

    @GetMapping(value="/consumer/payment/selectEntity/{idName}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("idName") Long id){
        String s = "http://CLOUD-PAYMENT-SERVICE";
        ResponseEntity<CommonResult> forEntity =
                restTemplate.getForEntity(s + "/payment/select/" + id, CommonResult.class);

         if(forEntity.getStatusCode().is2xxSuccessful()){
             return forEntity.getBody();
         }else{
             return null;
         }
    }
}
