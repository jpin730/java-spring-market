package com.example.javaspringmarket.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "purchase_item")
public class PurchaseItemEntity {
    @EmbeddedId
    private PurchaseProductPk id;

    private Integer quantity;

    private Double total;

    @ManyToOne
    @MapsId("purchaseId")
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

    public PurchaseEntity getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseEntity purchase) {
        this.purchase = purchase;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
