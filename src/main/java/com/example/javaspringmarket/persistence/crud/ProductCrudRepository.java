package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findByCategoryId(Integer categoryId);
}
