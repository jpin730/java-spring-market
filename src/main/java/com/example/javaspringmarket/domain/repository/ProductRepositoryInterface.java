package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.ProductCreateDto;
import com.example.javaspringmarket.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {
    List<ProductDto> getAll();

    List<ProductDto> getByCategory(Integer categoryId);

    Optional<ProductDto> getById(Integer productId);

    ProductDto save(ProductCreateDto product);

    void delete(Integer productId);
}
