package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ChengY
 * @date 2023/4/9 14:20
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationMain {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationMain.class,args);
    }
}
