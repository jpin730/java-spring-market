package com.example.javaspringmarket.persistence;

import com.example.javaspringmarket.persistence.crud.ProductCrudRepository;
import com.example.javaspringmarket.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public Optional<Product> getById(int id) {
        return productCrudRepository.findById(id);
    }

    public List<Product> getByCategory(int categoryId) {
        return productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
    }

    public Optional<List<Product>> getScarceProducts(int quantity) {
        return productCrudRepository.findByStockLessThanAndStatus(quantity, true);
    }

    public Product save(Product product) {
        return productCrudRepository.save(product);
    }

    public void delete(int id) {
        productCrudRepository.deleteById(id);
    }
}
