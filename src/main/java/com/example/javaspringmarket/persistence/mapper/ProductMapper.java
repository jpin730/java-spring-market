package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.product.ProductCreateDto;
import com.example.javaspringmarket.domain.dto.product.ProductDto;
import com.example.javaspringmarket.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    ProductDto toDto(ProductEntity product);

    List<ProductDto> toDtoList(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "purchaseItems", ignore = true)
    ProductEntity toEntity(ProductCreateDto product);
}
