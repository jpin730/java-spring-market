package com.example.javaspringmarket.persistence.repository;

import com.example.javaspringmarket.domain.dto.customer.CustomerCreateDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerDto;
import com.example.javaspringmarket.domain.dto.customer.CustomerUpdateDto;
import com.example.javaspringmarket.domain.repository.CustomerRepositoryInterface;
import com.example.javaspringmarket.persistence.crud.CustomerCrudRepository;
import com.example.javaspringmarket.persistence.entity.CustomerEntity;
import com.example.javaspringmarket.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements CustomerRepositoryInterface {
    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAll() {
        List<CustomerEntity> entities = customerCrudRepository.findAllByOrderByIdAsc();
        return customerMapper.toDtoList(entities);
    }

    @Override
    public Optional<CustomerDto> getById(Integer id) {
        Optional<CustomerEntity> entity = customerCrudRepository.findById(id);
        return entity.map(customerMapper::toDto);
    }

    @Override
    public CustomerDto save(CustomerCreateDto customer) {
        CustomerEntity entity = customerMapper.toCreateEntity(customer);
        return customerMapper.toDto(customerCrudRepository.save(entity));
    }

    @Override
    public void update(CustomerUpdateDto customer) {
        CustomerEntity entity = customerMapper.toUpdateEntity(customer);
        customerCrudRepository.save(entity);
    }


    @Override
    public void delete(Integer customerId) {
        customerCrudRepository.deleteById(customerId);
    }
}
