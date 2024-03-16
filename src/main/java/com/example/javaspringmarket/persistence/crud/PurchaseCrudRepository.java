package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEntity, Integer> {
    List<PurchaseEntity> findAllByOrderByIdAsc();

    List<PurchaseEntity> findByCustomerIdOrderByIdAsc(Integer customerId);
}
