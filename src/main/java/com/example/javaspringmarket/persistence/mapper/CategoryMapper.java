package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.CategoryDto;
import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "active", source = "status")
    })
    CategoryDto toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(CategoryDto category);
}
