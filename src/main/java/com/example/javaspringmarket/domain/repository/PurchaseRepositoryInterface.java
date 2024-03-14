package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryInterface {
    List<Purchase> getAll();

    Optional<Purchase> getById(int purchaseId);

    Optional<List<Purchase>> getByCustomerId(int customerId);

    Purchase save(Purchase purchase);

    void delete(int purchaseId);
}
