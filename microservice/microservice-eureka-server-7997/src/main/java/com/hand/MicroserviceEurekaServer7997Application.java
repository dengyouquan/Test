package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaServer7997Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaServer7997Application.class, args);
    }
}
