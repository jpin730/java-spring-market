package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryDto;
import com.example.javaspringmarket.domain.dto.CategoryUpdateDto;
import com.example.javaspringmarket.persistence.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getAll() {
        return categoryRepository.getAll();
    }

    public String create(CategoryCreateDto category) {
        return "create";
    }

    public String update(CategoryUpdateDto category) {
        return "update";
    }

    public String delete(Integer id) {
        return "delete";
    }
}
