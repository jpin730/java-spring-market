package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.Product;
import com.example.javaspringmarket.domain.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoryInterface productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getById(int id) {
        return productRepository.getById(id);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarceProducts(int quantity) {
        return productRepository.getScarceProducts(quantity);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        return getById(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
