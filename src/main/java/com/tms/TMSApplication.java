package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(TMSApplication.class, args);
    }

}
