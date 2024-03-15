package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryUpdateDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public String getAll() {
        return "All categories";
    }

    @PostMapping
    public String create(@RequestBody CategoryCreateDto body) {
        return "Category created";
    }

    @PutMapping
    public String update(@RequestBody CategoryUpdateDto body) {
        return "Category updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer categoryId) {
        return "Category deleted";
    }
}
