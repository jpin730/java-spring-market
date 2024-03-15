package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    public String getAll() {
        return "getAll";
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
