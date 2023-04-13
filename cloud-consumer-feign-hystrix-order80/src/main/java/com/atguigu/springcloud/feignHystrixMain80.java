package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ChengY
 * @date 2023/4/11 16:44
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class feignHystrixMain80 {
    public static void main(String[] args) {

        SpringApplication.run(feignHystrixMain80.class,args);
    }
}
