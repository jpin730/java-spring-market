package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.Product;
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

    public Product update(int productId, Product product) {
        Optional<Product> productToUpdate = getById(productId);
        if (productToUpdate.isEmpty()) {
            return null;
        }
        productToUpdate.map(product1 -> {
            product1.setName(product.getName());
            product1.setCategoryId(product.getCategoryId());
            product1.setPrice(product.getPrice());
            product1.setStock(product.getStock());
            product1.setActive(product.isActive());
            return productRepository.save(product1);
        });

        return productToUpdate.get();
    }

    public boolean delete(int productId) {
        return getById(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
