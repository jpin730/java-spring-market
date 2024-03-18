package com.example.javaspringmarket.persistence.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_item")
public class PurchaseItemEntity {
    @EmbeddedId
    private PurchaseItemPk id;

    private Integer quantity;

    private Double total;

    public PurchaseItemPk getId() {
        return id;
    }

    public void setId(PurchaseItemPk id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
