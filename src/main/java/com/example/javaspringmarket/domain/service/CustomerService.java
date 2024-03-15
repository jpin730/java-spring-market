package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;
import com.example.javaspringmarket.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> getAll() {
        return customerRepository.getAll();
    }

    public Optional<CustomerDto> getById(Integer id) {
        return customerRepository.getById(id);
    }

    public CustomerDto create(CustomerCreateDto customer) {
        return customerRepository.save(customer);
    }

    public Boolean update(CustomerUpdateDto customer) {
        return getById(customer.getId()).map(found -> {
            customerRepository.update(customer);
            return true;
        }).orElse(false);
    }


    public Boolean delete(Integer id) {
        return getById(id).map(customer -> {
            customerRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
