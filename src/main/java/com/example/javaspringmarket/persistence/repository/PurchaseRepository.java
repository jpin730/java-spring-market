package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.Purchase;
import com.example.javaspringmarket.domain.repository.PurchaseRepositoryInterface;
import com.example.javaspringmarket.persistence.crud.PurchaseCrudRepository;
import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import com.example.javaspringmarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchaseRepositoryInterface {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<PurchaseEntity>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<Purchase> getById(int purchaseId) {
        Optional<PurchaseEntity> purchaseEntity = purchaseCrudRepository.findById(purchaseId);
        return purchaseEntity.map(purchase -> purchaseMapper.toPurchase(purchase));
    }

    @Override
    public Optional<List<Purchase>> getByCustomerId(int customerId) {
        return purchaseCrudRepository.findByCustomerId(customerId).map(purchases -> purchaseMapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEntity purchaseEntity = purchaseMapper.toPurchase(purchase);
        purchaseEntity.getProducts().forEach(product -> product.setPurchase(purchaseEntity));
        return purchaseMapper.toPurchase(purchaseCrudRepository.save(purchaseEntity));
    }

    @Override
    public void delete(int productId) {
        purchaseCrudRepository.deleteById(productId);
    }
}
