package com.example.balancee_rewards.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CashbackTransactionDTO {
    private String transactionId;
    private BigDecimal amountEarned;
    private LocalDateTime transactionDate;
    private String customerId;
    private String description;

    public CashbackTransactionDTO() {
    }

    public CashbackTransactionDTO(String transactionId, BigDecimal amountEarned, LocalDateTime transactionDate, String customerId, String description) {
        this.transactionId = transactionId;
        this.amountEarned = amountEarned;
        this.transactionDate = transactionDate;
        this.customerId = customerId;
        this.description = description;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmountEarned() {
        return amountEarned;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDescription(){
        return description;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmountEarned(BigDecimal amountEarned) {
        this.amountEarned = amountEarned;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
