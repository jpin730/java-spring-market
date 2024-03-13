package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryInterface {
    List<Product> getAll();

    Optional<Product> getById(int productId);

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getScarceProducts(int quantity);

    Product save(Product product);

    void delete(int productId);
}
