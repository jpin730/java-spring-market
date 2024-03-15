package com.example.javaspringmarket.domain.dto.customer;

public class CustomerUpdateDto extends CustomerCreateDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
