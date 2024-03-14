package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.PurchaseDto;
import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    PurchaseDto toPurchase(PurchaseEntity purchase);

    List<PurchaseDto> toPurchases(List<PurchaseEntity> purchases);

    @Mapping(target = "customer", ignore = true)
    PurchaseEntity toPurchase(PurchaseDto purchase);
}
