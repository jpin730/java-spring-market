package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.Purchase;
import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    Purchase toPurchase(PurchaseEntity purchase);

    List<Purchase> toPurchases(List<PurchaseEntity> purchases);

    @Mapping(target = "customer", ignore = true)
    PurchaseEntity toPurchase(Purchase purchase);
}
