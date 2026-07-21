package com.diacore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.diacore"})
public class ApiWriteApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiWriteApplication.class, args);
    }
}
