package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryInterface {
    List<CategoryDto> getAll();

    Optional<CategoryDto> getById(Integer id);

    CategoryDto save(CategoryCreateDto category);

    void delete(Integer categoryId);
}
