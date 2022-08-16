package com.dyne.viid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ViidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViidApplication.class, args);
    }
    
}
