package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.product.ProductUpdateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    public String getAll() {
        return "getAll purchases";
    }

    public String getByCustomer(Integer customerId) {
        return "get purchases by customer id: " + customerId;
    }

    public String getById(Integer id) {
        return "get purchase by id: " + id;
    }

    public String create(PurchaseCreateDto purchase) {
        return "create purchase";
    }

    public String update(ProductUpdateDto purchase) {
        return "update purchase";
    }

    public String delete(Integer id) {
        return "delete purchase by id: " + id;
    }
}
