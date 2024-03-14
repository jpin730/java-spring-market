package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    Optional<List<PurchaseEntity>> findByCustomerId(int customerId);
}
