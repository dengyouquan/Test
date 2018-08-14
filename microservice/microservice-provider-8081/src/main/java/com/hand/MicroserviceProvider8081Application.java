package com.hand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hand.infra.mapper")
public class MicroserviceProvider8081Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProvider8081Application.class, args);
    }
}
