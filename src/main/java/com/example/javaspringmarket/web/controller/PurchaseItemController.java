package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemCreateDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemDto;
import com.example.javaspringmarket.domain.dto.purchase_item.PurchaseItemUpdateDto;
import com.example.javaspringmarket.domain.service.PurchaseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-items")
public class PurchaseItemController {
    @Autowired
    private PurchaseItemService purchaseItemService;

    @GetMapping
    public ResponseEntity<List<PurchaseItemDto>> getAll(@RequestParam(value = "purchase", required = false) Integer purchaseId) {
        return new ResponseEntity<>(purchaseId != null ? purchaseItemService.getByPurchase(purchaseId) : purchaseItemService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PurchaseItemDto> create(@RequestBody PurchaseItemCreateDto body) {
        return purchaseItemService.create(body)
                .map(purchaseItemDto -> new ResponseEntity<>(purchaseItemDto, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PurchaseItemUpdateDto body) {
        return new ResponseEntity<>(purchaseItemService.update(body) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam(value = "purchase") Integer purchaseId, @RequestParam(value = "product") Integer productId) {
        return new ResponseEntity<>(purchaseItemService.delete(purchaseId, productId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
