package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ChengY
 * @date 2023/4/8 17:27
 */
@SpringBootApplication
@EnableEurekaServer
public class eurekaServiceMain {

    public static void main(String[] args) {

        SpringApplication.run(eurekaServiceMain.class,args);
    }
}
