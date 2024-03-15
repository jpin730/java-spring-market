package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryDto;
import com.example.javaspringmarket.domain.dto.CategoryUpdateDto;
import com.example.javaspringmarket.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public String create(@RequestBody CategoryCreateDto body) {
        return categoryService.create(body);
    }

    @PutMapping
    public String update(@RequestBody CategoryUpdateDto body) {
        return categoryService.update(body);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer categoryId) {
        return categoryService.delete(categoryId);
    }
}
