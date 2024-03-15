package com.example.javaspringmarket.domain.dto.purchase;

import com.example.javaspringmarket.domain.dto.customer.CustomerDto;

public class PurchaseDto {
    private Integer id;
    private Double total;
    private Boolean paid;
    private CustomerDto customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
