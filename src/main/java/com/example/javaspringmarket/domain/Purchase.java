package com.example.javaspringmarket.domain;

import com.example.javaspringmarket.persistence.entity.PurchaseProductEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int id;
    private int customerId;
    private LocalDateTime date;
    private String state;
    private List<PurchaseProductEntity> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseProductEntity> products) {
        this.products = products;
    }
}
