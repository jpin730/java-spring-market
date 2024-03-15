package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.CategoryCreateDto;
import com.example.javaspringmarket.domain.dto.CategoryDto;
import com.example.javaspringmarket.domain.repository.CategoryRepositoryInterface;
import com.example.javaspringmarket.persistence.crud.CategoryCrudRepository;
import com.example.javaspringmarket.persistence.entity.CategoryEntity;
import com.example.javaspringmarket.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<CategoryDto> getById(Integer id) {
        Optional<CategoryEntity> entity = categoryCrudRepository.findById(id);
        return entity.map(categoryMapper::toDto);
    }

    @Override
    public CategoryDto save(CategoryCreateDto category) {
        CategoryEntity entity = categoryMapper.toEntity(category);
        return categoryMapper.toDto(categoryCrudRepository.save(entity));
    }

    @Override
    public void delete(Integer categoryId) {
        categoryCrudRepository.deleteById(categoryId);
    }
}
