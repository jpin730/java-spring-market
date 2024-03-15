package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.CategoryDto;
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
    @Mapping(target = "products", ignore = true)
    CategoryEntity toEntity(CategoryDto category);
}
