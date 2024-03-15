package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryDto;
import com.example.javaspringmarket.domain.dto.CategoryUpdateDto;
import com.example.javaspringmarket.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<CategoryDto> getById(Integer id) {
        return categoryRepository.getById(id);
    }

    public CategoryDto create(CategoryCreateDto category) {
        return categoryRepository.save(category);
    }

    public Boolean update(CategoryUpdateDto category) {
        return getById(category.getId()).map(found -> {
            categoryRepository.save(category);
            return true;
        }).orElse(false);
    }

    public Boolean delete(Integer id) {
        return getById(id).map(category -> {
            categoryRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
