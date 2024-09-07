package com.example.balancee_rewards.dto;

import java.math.BigDecimal;

public class CustomerDTO {
    private String transactionId;
    private BigDecimal totalCashback;
    private BigDecimal currentBalance;

    public CustomerDTO(){
    }

    public CustomerDTO(String transactionId, BigDecimal totalCashback, BigDecimal currentBalance) {
        this.transactionId = transactionId;
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getTotalCashback() {
        return totalCashback;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setTotalCashback(BigDecimal totalCashback) {
        this.totalCashback = totalCashback;
    }
}
