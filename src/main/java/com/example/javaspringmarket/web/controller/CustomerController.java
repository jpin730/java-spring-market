package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping
    public String getAll() {
        return "Get all customers";
    }

    @PostMapping
    public String create(@RequestBody CustomerCreateDto body) {
        return "Create customer";
    }

    @PutMapping
    public String update(@RequestBody CustomerUpdateDto body) {
        return "Update customer";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer customerId) {
        return "Delete customer with id " + customerId;
    }
}
