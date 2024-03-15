package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;
import com.example.javaspringmarket.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getAll() {
        return customerService.getAll();
    }

    @PostMapping
    public String create(@RequestBody CustomerCreateDto body) {
        return customerService.create(body);
    }

    @PutMapping
    public String update(@RequestBody CustomerUpdateDto body) {
        return customerService.update(body);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer customerId) {
        return customerService.delete(customerId);
    }
}
