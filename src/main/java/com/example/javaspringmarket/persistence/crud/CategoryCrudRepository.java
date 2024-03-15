package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
}
