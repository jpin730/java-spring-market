package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import com.example.javaspringmarket.persistence.entity.PurchaseItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
    @Mapping(target = "productId", source = "id.productId")
    PurchaseItemDto toDto(PurchaseItemEntity purchaseItem);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "product", ignore = true)
    PurchaseItemEntity toCreateEntity(PurchaseItemCreateDto purchaseItem);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "purchase", ignore = true)
    @Mapping(target = "product", ignore = true)
    PurchaseItemEntity toUpdateEntity(PurchaseItemUpdateDto purchaseItem);
}
