package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.CategoryDto;

import java.util.List;

public interface CategoryRepositoryInterface {
    List<CategoryDto> getAll();
}
