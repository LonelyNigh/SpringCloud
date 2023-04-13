package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author ChengY
 * @date 2023/4/12 15:29
 */
@SpringBootApplication
@EnableHystrixDashboard
public class dashboardMain9001 {
    public static void main(String[] args) {

        SpringApplication.run(dashboardMain9001.class,args);
    }

}
