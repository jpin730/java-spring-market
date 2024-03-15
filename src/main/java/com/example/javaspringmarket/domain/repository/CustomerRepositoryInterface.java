package com.example.javaspringmarket.domain.repository;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryInterface {
    List<CustomerDto> getAll();

    Optional<CustomerDto> getById(Integer id);

    CustomerDto save(CustomerCreateDto customer);

    void update(CustomerUpdateDto customer);

    void delete(Integer customerId);
}
