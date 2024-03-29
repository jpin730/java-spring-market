package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.purchase.PurchaseCreateDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseListDto;
import com.example.javaspringmarket.domain.dto.purchase.PurchaseUpdateDto;
import com.example.javaspringmarket.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    @Operation(summary = "Get all purchases with optional customer filter")
    public ResponseEntity<List<PurchaseListDto>> getAll(@RequestParam(value = "customer", required = false) Integer customerId) {
        List<PurchaseListDto> purchases = customerId != null ? purchaseService.getByCustomer(customerId) : purchaseService.getAll();
        return new ResponseEntity<>(purchases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a purchase by id")
    public ResponseEntity<PurchaseDto> getById(@PathVariable Integer id) {
        return purchaseService.getById(id).map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @Operation(summary = "Create a new purchase")
    public ResponseEntity<PurchaseDto> create(@RequestBody PurchaseCreateDto body) {
        return new ResponseEntity<>(purchaseService.create(body), HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update a purchase")
    public ResponseEntity<Void> update(@RequestBody PurchaseUpdateDto body) {
        return new ResponseEntity<>(purchaseService.update(body) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a purchase")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(purchaseService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
