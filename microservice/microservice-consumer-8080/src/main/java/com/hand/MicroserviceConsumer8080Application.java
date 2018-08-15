package com.hand;

import ribbon.rule.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-privoder",configuration = RibbonConfig.class)
public class MicroserviceConsumer8080Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumer8080Application.class, args);
    }
}
