package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.PurchaseItemEntity;
import com.example.javaspringmarket.persistence.entity.PurchaseItemPk;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseItemCrudRepository extends CrudRepository<PurchaseItemEntity, PurchaseItemPk> {
    List<PurchaseItemEntity> findAllByOrderByIdPurchaseIdAsc();

    List<PurchaseItemEntity> findByIdPurchaseIdOrderByIdPurchaseId(Integer idPurchase);
}
