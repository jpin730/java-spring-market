package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.product.ProductCreateDto;
import com.example.javaspringmarket.domain.dto.product.ProductDto;
import com.example.javaspringmarket.domain.dto.product.ProductUpdateDto;
import com.example.javaspringmarket.domain.repository.ProductRepositoryInterface;
import com.example.javaspringmarket.persistence.crud.ProductCrudRepository;
import com.example.javaspringmarket.persistence.entity.ProductEntity;
import com.example.javaspringmarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryInterface {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> entities = productCrudRepository.findAllByOrderByIdAsc();
        return productMapper.toDtoList(entities);
    }

    @Override
    public List<ProductDto> getByCategory(Integer categoryId) {
        List<ProductEntity> entities = productCrudRepository.findByCategoryIdOrderByIdAsc(categoryId);
        return productMapper.toDtoList(entities);
    }

    @Override
    public Optional<ProductDto> getById(Integer id) {
        Optional<ProductEntity> entity = productCrudRepository.findById(id);
        return entity.map(productMapper::toDto);
    }

    @Override
    public ProductDto save(ProductCreateDto product) {
        ProductEntity entity = productMapper.toCreateEntity(product);
        return productMapper.toDto(productCrudRepository.save(entity));
    }

    @Override
    public void update(ProductUpdateDto product) {
        ProductEntity entity = productMapper.toUpdateEntity(product);
        productCrudRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        productCrudRepository.deleteById(id);
    }
}
