package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.category.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.category.CategoryDto;
import com.example.javaspringmarket.domain.dto.category.CategoryUpdateDto;
import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(CategoryEntity category);

    List<CategoryDto> toDtoList(List<CategoryEntity> categories);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    CategoryEntity toCreateEntity(CategoryCreateDto category);

    @Mapping(target = "products", ignore = true)
    CategoryEntity toUpdateEntity(CategoryUpdateDto category);
}
