package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryInterface {
    List<Purchase> getAll();

    Optional<Purchase> getById(int purchaseId);

    Optional<Purchase> getByClientId(int clientId);

    Purchase save(Purchase product);

    void delete(int productId);
}
