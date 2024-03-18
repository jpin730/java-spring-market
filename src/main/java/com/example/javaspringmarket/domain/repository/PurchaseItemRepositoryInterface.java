package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemDto;
import com.example.javaspringmarket.persistence.entity.PurchaseItemPk;

import java.util.List;
import java.util.Optional;

public interface PurchaseItemRepositoryInterface {
    List<PurchaseItemDto> getAll();

    List<PurchaseItemDto> getByPurchase(Integer purchaseId);

    Optional<PurchaseItemDto> getById(PurchaseItemPk purchaseItemPk);

    Optional<PurchaseItemDto> save(PurchaseItemPk pk, PurchaseItemCreateDto purchaseItem);

    void delete(PurchaseItemPk purchaseItemPk);
}
