package com.example.javaspringmarket.domain.dto.purchase_item;

import com.example.javaspringmarket.domain.dto.product.ProductDto;

public class PurchaseItemDto {
    private Integer quantity;
    private Double total;
    private Integer purchaseId;
    private ProductDto product;

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

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
