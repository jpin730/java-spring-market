package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.PurchaseDto;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryInterface {
    List<PurchaseDto> getAll();

    Optional<PurchaseDto> getById(int purchaseId);

    Optional<List<PurchaseDto>> getByCustomerId(int customerId);

    PurchaseDto save(PurchaseDto purchase);

    void delete(int purchaseId);
}
