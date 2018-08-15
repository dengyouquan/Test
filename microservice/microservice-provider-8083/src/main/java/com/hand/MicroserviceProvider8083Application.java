package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.hand.infra.mapper")
public class MicroserviceProvider8083Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProvider8083Application.class, args);
    }
}
