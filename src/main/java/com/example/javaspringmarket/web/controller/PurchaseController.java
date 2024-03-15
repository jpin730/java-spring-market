package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.product.ProductUpdateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @GetMapping
    public String getAll(@RequestParam(value = "customer", required = false) Integer userId) {
        return "Get all purchases" + (userId != null ? " by user" : "");
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return "Get purchase by id";
    }

    @PostMapping
    public String create(@RequestBody PurchaseCreateDto body) {
        return "Create purchase";
    }

    @PutMapping
    public String update(@RequestBody ProductUpdateDto body) {
        return "Update purchase";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return "Delete purchase";
    }
}
