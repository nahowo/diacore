package com.diacore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.diacore"})
public class ApiReadApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiReadApplication.class, args);
    }
}
