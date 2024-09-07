package com.example.balancee_rewards.model;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    private String customerId;

    // using BigDecimal because we are dealing with number
    @Column(name = "total_cashback", nullable = false)
    private BigDecimal totalCashback;

    @Column(name = "current_balance", nullable = false)
    private BigDecimal currentBalance;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CashbackTransaction> transactions;

    public Customer() {
    }

    public Customer(Long id, String customerId, BigDecimal totalCashback, BigDecimal currentBalance) {
        this.customerId = customerId;
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotalCashback() {
        return totalCashback;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    // Setters
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }

    public void setTotalCashback(BigDecimal totalCashback) {
        this.totalCashback = totalCashback;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }
}