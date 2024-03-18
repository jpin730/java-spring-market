package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseListDto;
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
    public List<PurchaseListDto> getAll() {
        List<PurchaseEntity> entities = purchaseCrudRepository.findAllByOrderByIdAsc();
        return purchaseMapper.toDtoList(entities);
    }

    @Override
    public List<PurchaseListDto> getByCustomer(Integer customerId) {
        List<PurchaseEntity> entities = purchaseCrudRepository.findByCustomerIdOrderByIdAsc(customerId);
        return purchaseMapper.toDtoList(entities);
    }

    @Override
    public Optional<PurchaseDto> getById(Integer purchaseId) {
        Optional<PurchaseEntity> entity = purchaseCrudRepository.findById(purchaseId);
        return entity.map(purchaseMapper::toDto);
    }

    @Override
    public PurchaseDto save(PurchaseCreateDto purchase) {
        PurchaseEntity entity = purchaseMapper.toCreateEntity(purchase);
        entity.setTotal(0.0);
        entity.setPaid(false);
        return purchaseMapper.toDto(purchaseCrudRepository.save(entity));
    }

    @Override
    public void update(PurchaseDto purchase) {
        PurchaseEntity entity = purchaseMapper.toUpdateEntity(purchase);
        purchaseCrudRepository.save(entity);
    }

    @Override
    public void delete(Integer purchaseId) {
        purchaseCrudRepository.deleteById(purchaseId);
    }
}
