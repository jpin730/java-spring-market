package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<ProductEntity>> findByStockLessThanAndStatus(int stock, boolean status);
}
