package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.CategoryDto;
import com.example.javaspringmarket.domain.repository.CategoryRepositoryInterface;
import com.example.javaspringmarket.persistence.crud.CategoryCrudRepository;
import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import com.example.javaspringmarket.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository implements CategoryRepositoryInterface {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryEntity> entities = (List<CategoryEntity>) categoryCrudRepository.findAll();
        return categoryMapper.toDtoList(entities);
    }
}
