package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
}
