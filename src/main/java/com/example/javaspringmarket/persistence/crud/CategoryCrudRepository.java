package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryCrudRepository extends CrudRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAllByOrderByIdAsc();
}
