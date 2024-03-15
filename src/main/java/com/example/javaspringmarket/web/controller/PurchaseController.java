package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.product.ProductUpdateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import com.example.javaspringmarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public String getAll(@RequestParam(value = "customer", required = false) Integer customerId) {
        return customerId != null ? purchaseService.getByCustomer(customerId) : purchaseService.getAll();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        return purchaseService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody PurchaseCreateDto body) {
        return purchaseService.create(body);
    }

    @PutMapping
    public String update(@RequestBody ProductUpdateDto body) {
        return purchaseService.update(body);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return purchaseService.delete(id);
    }
}
