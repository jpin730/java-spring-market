package com.example.javaspringmarket.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private String customerId;

    private LocalDateTime date;

    private String state;

    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProductEntity> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
