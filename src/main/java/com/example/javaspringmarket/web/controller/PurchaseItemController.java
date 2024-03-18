package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase-items")
public class PurchaseItemController {


    @GetMapping
    public ResponseEntity<String> getAll(@RequestParam(value = "purchase", required = false) Integer purchaseId) {
        return new ResponseEntity<>(purchaseId != null ? "Get purchase items by purchase id" : "Get all purchase items", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PurchaseItemCreateDto body) {
        return new ResponseEntity<>("Create purchase item", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody PurchaseItemUpdateDto body) {
        return new ResponseEntity<>("Update purchase item", HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> delete(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>("Delete purchase item", HttpStatus.OK);
    }
}
