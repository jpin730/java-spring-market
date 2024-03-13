package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.Category;
import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(target = "name", source = "description"),
            @Mapping(target = "active", source = "status")
    })
    Category toCategory(CategoryEntity categoryEntity);

    @InheritInverseConfiguration
    CategoryEntity toCategoryEntity(Category category);
}
