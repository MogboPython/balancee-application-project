package com.example.balancee_rewards.dto;

import java.time.LocalDateTime;

public class CashbackTransactionDTO {
    private String transactionId;
    private Double amountEarned;
    private LocalDateTime transactionDate;
    private String customerId;

    public CashbackTransactionDTO() {
    }

    public CashbackTransactionDTO(String transactionId, Double amountEarned, LocalDateTime transactionDate, String customerId) {
        this.transactionId = transactionId;
        this.amountEarned = amountEarned;
        this.transactionDate = transactionDate;
        this.customerId = customerId;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public Double getAmountEarned() {
        return amountEarned;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmountEarned(Double amountEarned) {
        this.amountEarned = amountEarned;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
