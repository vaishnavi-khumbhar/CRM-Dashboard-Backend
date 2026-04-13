package com.crm.project.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private Double amount;
    private LocalDate date;

    private Long customerId; // simple FK (no relation for now)

    public Sale() {}

    public Sale(String product, Double amount, LocalDate date, Long customerId) {
        this.product = product;
        this.amount = amount;
        this.date = date;
        this.customerId = customerId;
    }

    public Long getId() { return id; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
