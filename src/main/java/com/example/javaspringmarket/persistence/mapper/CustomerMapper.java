package com.example.javaspringmarket.persistence.mapper;

import com.example.javaspringmarket.domain.dto.customer.CustomerDto;
import com.example.javaspringmarket.persistence.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(CustomerEntity customer);

    List<CustomerDto> toDtoList(List<CustomerEntity> customers);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchases", ignore = true)
    CustomerEntity toEntity(CustomerDto customer);
}
