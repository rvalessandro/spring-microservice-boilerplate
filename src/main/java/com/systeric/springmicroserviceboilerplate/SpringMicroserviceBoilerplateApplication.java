package com.systeric.springmicroserviceboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})

public class SpringMicroserviceBoilerplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMicroserviceBoilerplateApplication.class, args);
    }

}
