package com.mxs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AccessModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessModuleApplication.class, args);
    }
}
