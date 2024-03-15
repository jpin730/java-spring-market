package com.example.javaspringmarket.domain.dto;

public class ProductUpdateDto extends ProductCreateDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
