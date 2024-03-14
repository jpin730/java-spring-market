package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {
    List<ProductDto> getAll();

    Optional<ProductDto> getById(int productId);

    Optional<List<ProductDto>> getByCategory(int categoryId);

    Optional<List<ProductDto>> getScarceProducts(int quantity);

    ProductDto save(ProductDto product);

    void delete(int productId);
}
