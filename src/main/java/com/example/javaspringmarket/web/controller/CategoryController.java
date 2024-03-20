package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.category.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.category.CategoryDto;
import com.example.javaspringmarket.domain.dto.category.CategoryUpdateDto;
import com.example.javaspringmarket.domain.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all categories")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a new category")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryCreateDto body) {
        return new ResponseEntity<>(categoryService.create(body), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update a category")
    public ResponseEntity<Void> update(@RequestBody CategoryUpdateDto body) {
        return new ResponseEntity<>(categoryService.update(body) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer categoryId) {
        return new ResponseEntity<>(categoryService.delete(categoryId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
