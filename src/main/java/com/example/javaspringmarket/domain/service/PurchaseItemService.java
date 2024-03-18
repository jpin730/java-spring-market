package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import com.example.javaspringmarket.persistence.entity.PurchaseItemPk;
import com.example.javaspringmarket.persistence.repository.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseItemService {
    @Autowired
    private PurchaseItemRepository purchaseItemRepository;


    public List<PurchaseItemDto> getAll() {
        return purchaseItemRepository.getAll();
    }

    public List<PurchaseItemDto> getByPurchase(Integer purchaseId) {
        return purchaseItemRepository.getByPurchase(purchaseId);
    }

    public Optional<PurchaseItemDto> create(PurchaseItemCreateDto purchaseItem) {
        Optional<PurchaseItemPk> pk = purchaseItemRepository.getPk(purchaseItem.getPurchaseId(), purchaseItem.getProductId());
        if (pk.isEmpty()) {
            return Optional.empty();
        }

        Optional<PurchaseItemDto> found = purchaseItemRepository.getById(pk.get());
        if (found.isPresent()) {
            return Optional.empty();
        }

        return purchaseItemRepository.save(pk.get(), purchaseItem);
    }

    public Boolean update(PurchaseItemUpdateDto purchaseItem) {
        Optional<PurchaseItemPk> pk = purchaseItemRepository.getPk(purchaseItem.getPurchaseId(), purchaseItem.getProductId());
        if (pk.isEmpty()) {
            return false;
        }

        Optional<PurchaseItemDto> found = purchaseItemRepository.getById(pk.get());
        if (found.isEmpty()) {
            return false;
        }

        purchaseItemRepository.save(pk.get(), purchaseItem);
        return true;
    }

    public Boolean delete(Integer purchaseId, Integer productId) {
        Optional<PurchaseItemPk> pk = purchaseItemRepository.getPk(purchaseId, productId);
        if (pk.isEmpty()) {
            return false;
        }

        Optional<PurchaseItemDto> found = purchaseItemRepository.getById(pk.get());
        if (found.isEmpty()) {
            return false;
        }

        purchaseItemRepository.delete(pk.get());
        return true;
    }
}
