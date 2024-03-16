package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryInterface {
    List<PurchaseDto> getAll();

    List<PurchaseDto> getByCustomer(Integer customerId);

    Optional<PurchaseDto> getById(Integer purchaseId);

    PurchaseDto save(PurchaseCreateDto purchase);

    void update(PurchaseDto purchase);

    void delete(Integer purchaseId);
}
