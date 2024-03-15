package com.example.javaspringmarket.domain.service;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public String getAll() {
        return "getAll";
    }

    public String getById(Integer id) {
        return "getById";
    }

    public String create(CustomerCreateDto customer) {
        return "create";
    }

    public String update(CustomerUpdateDto customer) {
        return "update";
    }


    public String delete(Integer id) {
        return "delete";
    }
}
