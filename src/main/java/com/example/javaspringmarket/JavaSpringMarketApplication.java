package com.example.javaspringmarket;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Java Spring Market", version = "1.0", description = "Frontend (Angular): https://angular-spring-market.vercel.app"))
public class JavaSpringMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringMarketApplication.class, args);
    }
}
