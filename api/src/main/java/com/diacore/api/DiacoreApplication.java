package com.diacore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.diacore")
public class DiacoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiacoreApplication.class, args);
    }
}
