package com.example.javaspringmarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_product")
public class PurchaseProductEntity {
    @EmbeddedId
    private PurchaseProductPk id;

    private Integer quantity;

    private Double total;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductEntity product;

    public PurchaseProductPk getId() {
        return id;
    }

    public void setId(PurchaseProductPk id) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
