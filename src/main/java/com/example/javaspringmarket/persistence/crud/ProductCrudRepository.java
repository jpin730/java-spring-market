package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);
}
