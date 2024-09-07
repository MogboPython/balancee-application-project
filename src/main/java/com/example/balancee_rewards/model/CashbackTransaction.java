package com.example.balancee_rewards.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cashback_transactions")
public class CashbackTransaction {

    @Id
    @Column(name = "transaction_id", unique = true, nullable = false)
    private String transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "amount_earned", nullable = false)
    private Double amountEarned;

    @Column(name = "description", nullable = false)
    private String description;

    public CashbackTransaction() {
    }

    public CashbackTransaction(String transactionId, Customer customer, LocalDateTime transactionDate, Double amountEarned, String description) {
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

    public Double getAmountEarned(){
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

    public void setAmountEarned(Double amountEarned){
        this.amountEarned = amountEarned;
    }

    public void setDescription(String description){
        this.description = description;
    }
}