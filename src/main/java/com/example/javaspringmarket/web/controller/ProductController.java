package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.product.ProductCreateDto;
import com.example.javaspringmarket.domain.dto.product.ProductDto;
import com.example.javaspringmarket.domain.dto.product.ProductUpdateDto;
import com.example.javaspringmarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(@RequestParam(value = "category", required = false) Optional<Integer> categoryId) {
        return new ResponseEntity<>(productService.getAll(categoryId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Integer productId) {
        return productService.getById(productId).map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductCreateDto body) {
        return new ResponseEntity<>(productService.create(body), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ProductUpdateDto body) {
        return new ResponseEntity<>(productService.update(body) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer productId) {
        return new ResponseEntity<>(productService.delete(productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
