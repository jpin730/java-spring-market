package com.example.javaspringmarket.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.javaspringmarket.domain.Product;
import com.example.javaspringmarket.persistence.entity.ProductEntity;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "active", source = "status"),
            @Mapping(target = "category", source = "category"),
    })
    Product toProduct(ProductEntity product);

    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purchases", ignore = true),
    })
    ProductEntity toProductEntity(Product product);
}
