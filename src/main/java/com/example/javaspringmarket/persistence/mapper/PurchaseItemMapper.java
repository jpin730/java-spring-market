package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import com.example.javaspringmarket.persistence.entity.PurchaseItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
    @Mapping(target = "purchaseId", source = "id.purchase.id")
    @Mapping(target = "product.id", source = "id.product.id")
    @Mapping(target = "product.name", source = "id.product.name")
    @Mapping(target = "product.price", source = "id.product.price")
    @Mapping(target = "product.category", ignore = true)
    PurchaseItemDto toDto(PurchaseItemEntity purchaseItem);

    List<PurchaseItemDto> toDtoList(List<PurchaseItemEntity> purchaseItems);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "total", ignore = true)
    PurchaseItemEntity toCreateEntity(PurchaseItemCreateDto purchaseItem);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "total", ignore = true)
    PurchaseItemEntity toUpdateEntity(PurchaseItemUpdateDto purchaseItem);
}
