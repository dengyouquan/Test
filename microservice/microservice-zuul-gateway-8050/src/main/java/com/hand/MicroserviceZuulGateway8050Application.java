package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceZuulGateway8050Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceZuulGateway8050Application.class, args);
    }
}
