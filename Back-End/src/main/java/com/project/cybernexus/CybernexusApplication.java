package com.project.cybernexus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CybernexusApplication {

        @Value("${PORT:8080}")
        private int port;

    public static void main(String[] args) {
        SpringApplication.run(CybernexusApplication.class, args);
        System.out.println("Cybernexus Application Started");
    
    }

}
