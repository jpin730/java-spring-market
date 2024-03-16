package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseDto;
import com.example.javaspringmarket.persistence.entity.PurchaseEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface PurchaseMapper {
    PurchaseDto toDto(PurchaseEntity purchase);

    List<PurchaseDto> toDtoList(List<PurchaseEntity> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "paid", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "items", ignore = true)
    PurchaseEntity toCreateEntity(PurchaseCreateDto purchase);

    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "items", ignore = true)
    PurchaseEntity toUpdateEntity(PurchaseDto purchase);
}
