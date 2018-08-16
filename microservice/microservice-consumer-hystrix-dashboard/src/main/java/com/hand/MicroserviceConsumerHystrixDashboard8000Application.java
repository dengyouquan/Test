package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroserviceConsumerHystrixDashboard8000Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerHystrixDashboard8000Application.class, args);
    }
}
