package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.ProductDto;
import com.example.javaspringmarket.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "active", source = "status"),
            @Mapping(target = "category", source = "category"),
    })
    ProductDto toProduct(ProductEntity product);

    List<ProductDto> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchases", ignore = true),
    })
    ProductEntity toProductEntity(ProductDto product);
}
