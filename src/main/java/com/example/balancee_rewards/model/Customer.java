package com.example.balancee_rewards.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    private String customerId;

    @Column(name = "total_cashback", nullable = false)
    private Double totalCashback;

    @Column(name = "current_balance", nullable = false)
    private Double currentBalance;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CashbackTransaction> transactions;

    public Customer() {
    }

    public Customer(Long id, String customerId, Double totalCashback, Double currentBalance) {
        this.customerId = customerId;
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public Double getTotalCashback() {
        return totalCashback;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    // Setters
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }

    public void setTotalCashback(Double totalCashback) {
        this.totalCashback = totalCashback;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }
}