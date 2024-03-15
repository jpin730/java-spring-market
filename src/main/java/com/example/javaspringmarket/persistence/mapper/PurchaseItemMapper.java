package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.PurchaseItemDto;
import com.example.javaspringmarket.persistence.entity.PurchaseItemEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(target = "productId", source = "id.productId"),
            @Mapping(target = "active", source = "status"),
    })
    PurchaseItemDto toPurchaseItem(PurchaseItemEntity purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true),
    })
    PurchaseItemEntity toPurchaseProduct(PurchaseItemDto purchaseItem);
}
