package com.example.javaspringmarket.domain.dto.purchase;

public class PurchaseUpdateDto {
    private Integer id;
    private Boolean paid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
