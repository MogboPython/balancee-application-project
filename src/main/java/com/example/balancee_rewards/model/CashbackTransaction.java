package com.example.balancee_rewards.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cashback_transactions")
public class CashbackTransaction {

    @Id
    @Column(name = "transaction_id", unique = true, nullable = false)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Customer customer;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "amount_earned", nullable = false)
    private BigDecimal amountEarned;

    @Column(name = "description", nullable = false)
    private String description;

    public CashbackTransaction() {
    }

    public CashbackTransaction(String transactionId, Customer customer, LocalDateTime transactionDate, BigDecimal amountEarned, String description) {
        this.transactionId = transactionId;
        this.customer = customer;
        this.transactionDate = transactionDate;
        this.amountEarned = amountEarned;
        this.description = description;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public BigDecimal getAmountEarned(){
        return amountEarned;
    }

    public String getDescription(){
        return description;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAmountEarned(BigDecimal amountEarned){
        this.amountEarned = amountEarned;
    }

    public void setDescription(String description){
        this.description = description;
    }
}