package com.example.javaspringmarket.domain.dto.purchase;

public class PurchaseUpdateDto extends PurchaseCreateDto {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
