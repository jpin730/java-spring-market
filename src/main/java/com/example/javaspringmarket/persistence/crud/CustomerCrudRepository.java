package com.example.javaspringmarket.persistence.crud;

import com.example.javaspringmarket.persistence.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerCrudRepository extends CrudRepository<CustomerEntity, Integer> {
    List<CustomerEntity> findAllByOrderByIdAsc();
}
