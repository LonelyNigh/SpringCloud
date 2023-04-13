package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.swing.*;

/**
 * @author ChengY
 * @date 2023/4/11 8:59
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeign80Main {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign80Main.class,args);
    }
}
