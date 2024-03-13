package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.Product;
import com.example.javaspringmarket.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(target = "active", source = "status"),
            @Mapping(target = "category", ignore = true)
    })
    Product toProduct(ProductEntity product);

    List<Product> toProducts(List<ProductEntity> products);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(Product product);
}
