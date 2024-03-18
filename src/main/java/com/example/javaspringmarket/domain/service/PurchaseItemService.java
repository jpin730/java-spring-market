package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class PurchaseItemService {
    public String getAll() {
        return "getAll";
    }

    public String getByPurchase(Integer purchaseId) {
        return "getByPurchase";
    }

    public String create(PurchaseItemCreateDto purchaseItem) {
        return "create";
    }

    public String update(PurchaseItemUpdateDto purchaseItem) {
        return "update";
    }

    public String delete(Integer productId) {
        return "delete";
    }
}
