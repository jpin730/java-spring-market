package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemDto;
import com.example.javaspringmarket.domain.repository.PurchaseItemRepositoryInterface;
import com.example.javaspringmarket.persistence.crud.ProductCrudRepository;
import com.example.javaspringmarket.persistence.crud.PurchaseCrudRepository;
import com.example.javaspringmarket.persistence.crud.PurchaseItemCrudRepository;
import com.example.javaspringmarket.persistence.entity.ProductEntity;
import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import com.example.javaspringmarket.persistence.entity.PurchaseItemEntity;
import com.example.javaspringmarket.persistence.entity.PurchaseItemPk;
import com.example.javaspringmarket.persistence.mapper.PurchaseItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseItemRepository implements PurchaseItemRepositoryInterface {
    @Autowired
    private PurchaseItemCrudRepository purchaseItemCrudRepository;

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Override
    public List<PurchaseItemDto> getAll() {
        List<PurchaseItemEntity> entities = purchaseItemCrudRepository.findAllByOrderByIdPurchaseIdAsc();
        return purchaseItemMapper.toDtoList(entities);
    }

    @Override
    public List<PurchaseItemDto> getByPurchase(Integer purchaseId) {
        List<PurchaseItemEntity> entities = purchaseItemCrudRepository.findByIdPurchaseIdOrderByIdPurchaseId(purchaseId);
        return purchaseItemMapper.toDtoList(entities);
    }

    @Override
    public Optional<PurchaseItemDto> getById(PurchaseItemPk pk) {
        Optional<PurchaseItemEntity> entity = purchaseItemCrudRepository.findById(pk);
        return entity.map(purchaseItemMapper::toDto);
    }

    @Override
    public Optional<PurchaseItemDto> save(PurchaseItemPk pk, PurchaseItemCreateDto purchaseItem) {
        PurchaseItemEntity entity = purchaseItemMapper.toCreateEntity(purchaseItem);
        entity.setId(pk);
        entity.setTotal(purchaseItem.getQuantity() * pk.getProduct().getPrice());
        return Optional.of(purchaseItemMapper.toDto(purchaseItemCrudRepository.save(entity)));
    }

    @Override
    public void delete(PurchaseItemPk pk) {
        purchaseItemCrudRepository.deleteById(pk);
    }

    public Optional<PurchaseItemPk> getPk(Integer purchaseId, Integer productId) {
        Optional<PurchaseEntity> purchase = purchaseCrudRepository.findById(purchaseId);
        if (purchase.isEmpty()) {
            return Optional.empty();
        }

        Optional<ProductEntity> product = productCrudRepository.findById(productId);
        if (product.isEmpty()) {
            return Optional.empty();
        }

        PurchaseItemPk pk = new PurchaseItemPk();

        pk.setProduct(product.get());
        pk.setPurchase(purchase.get());

        return Optional.of(pk);
    }
}
