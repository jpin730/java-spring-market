package com.example.javaspringmarket.persistence;

import com.example.javaspringmarket.domain.Product;
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
    public List<Product> getAll() {
        List<ProductEntity> productEntities = (List<ProductEntity>) productCrudRepository.findAll();
        return productMapper.toProducts(productEntities);
    }

    @Override
    public Optional<Product> getById(int id) {
        Optional<ProductEntity> productEntity = productCrudRepository.findById(id);
        return productEntity.map(product -> productMapper.toProduct(product));
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEntity> productEntities = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProducts(productEntities));
    }

    @Override
    public Optional<List<Product>> getScarceProducts(int quantity) {
        Optional<List<ProductEntity>> productEntities = productCrudRepository.findByStockLessThanAndStatus(quantity, true);
        return productEntities.map(product -> productMapper.toProducts(product));
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toProductEntity(product);
        return productMapper.toProduct(productCrudRepository.save(productEntity));
    }

    @Override
    public void delete(int id) {
        productCrudRepository.deleteById(id);
    }
}
