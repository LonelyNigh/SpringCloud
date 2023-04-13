package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ChengY
 * @date 2023/4/13 14:41
 */
@SpringBootApplication
@EnableEurekaClient
public class gatewayMain {
    public static void main(String[] args) {
        SpringApplication.run(gatewayMain.class,args);
    }

}
