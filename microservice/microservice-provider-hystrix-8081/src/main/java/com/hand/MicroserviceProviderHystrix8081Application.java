package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker //启动熔断机制
@MapperScan("com.hand.infra.mapper")
public class MicroserviceProviderHystrix8081Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderHystrix8081Application.class, args);
    }
}
