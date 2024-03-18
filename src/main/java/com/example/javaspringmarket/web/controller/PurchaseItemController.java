package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import com.example.javaspringmarket.domain.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase-items")
public class PurchaseItemController {
    @Autowired
    private PurchaseItemService purchaseItemService;

    @GetMapping
    public ResponseEntity<String> getAll(@RequestParam(value = "purchase", required = false) Integer purchaseId) {
        return new ResponseEntity<>(purchaseId != null ? purchaseItemService.getByPurchase(purchaseId) : purchaseItemService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PurchaseItemCreateDto body) {
        return new ResponseEntity<>(purchaseItemService.create(body), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody PurchaseItemUpdateDto body) {
        return new ResponseEntity<>(purchaseItemService.update(body), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> delete(@PathVariable("productId") Integer productId) {
        return new ResponseEntity<>(purchaseItemService.delete(productId), HttpStatus.OK);
    }
}
