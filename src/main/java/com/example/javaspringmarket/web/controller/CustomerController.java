package com.example.javaspringmarket.web.controller;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;
import com.example.javaspringmarket.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAll() {
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody CustomerCreateDto body) {
        return new ResponseEntity<>(customerService.create(body), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody CustomerUpdateDto body) {
        return new ResponseEntity<>(customerService.update(body) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer customerId) {
        return new ResponseEntity<>(customerService.delete(customerId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
