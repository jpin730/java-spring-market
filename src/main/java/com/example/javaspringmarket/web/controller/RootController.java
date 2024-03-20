package com.example.javaspringmarket.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.sql.DataSource;

@RestController
@RequestMapping("/")
@Tag(name = "App Root")
public class RootController {
    @Autowired
    private DataSource dataSource;

    @GetMapping("/reset")
    @Operation(summary = "Reset database")
    public void resetDatabase() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("seed.sql"));
        populator.execute(dataSource);
    }

    @GetMapping
    @Operation(summary = "Redirect to Swagger UI")
    public RedirectView redirectToSwagger() {
        return new RedirectView("/api/swagger-ui.html");
    }
}
