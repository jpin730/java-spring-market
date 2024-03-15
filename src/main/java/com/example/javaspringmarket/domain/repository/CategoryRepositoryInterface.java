package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.category.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.category.CategoryDto;
import com.example.javaspringmarket.domain.dto.category.CategoryUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryInterface {
    List<CategoryDto> getAll();

    Optional<CategoryDto> getById(Integer id);

    CategoryDto save(CategoryCreateDto category);

    void update(CategoryUpdateDto category);

    void delete(Integer categoryId);
}
