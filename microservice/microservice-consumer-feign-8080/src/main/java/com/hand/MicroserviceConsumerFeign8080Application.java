package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.hand"})
@ComponentScan("com.hand")
public class MicroserviceConsumerFeign8080Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerFeign8080Application.class, args);
    }
}
