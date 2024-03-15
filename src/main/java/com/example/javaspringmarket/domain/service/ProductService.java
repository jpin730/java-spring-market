package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.ProductCreateDto;
import com.example.javaspringmarket.domain.dto.ProductDto;
import com.example.javaspringmarket.domain.dto.ProductUpdateDto;
import com.example.javaspringmarket.domain.repository.ProductRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositoryInterface productRepository;

    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDto> getById(Integer id) {
        return productRepository.getById(id);
    }

    public ProductDto create(ProductCreateDto product) {
        return productRepository.save(product);
    }

    public Boolean update(ProductUpdateDto body) {
        return getById(body.getId()).map(found -> {
            productRepository.save(body);
            return true;
        }).orElse(false);
    }

    public Boolean delete(Integer id) {
        return getById(id).map(product -> {
            productRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
