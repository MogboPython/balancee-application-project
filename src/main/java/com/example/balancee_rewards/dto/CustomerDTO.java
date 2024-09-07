package com.example.balancee_rewards.dto;

import java.math.BigDecimal;

public class CustomerDTO {
    private String customerId;
    private BigDecimal totalCashback;
    private BigDecimal currentBalance;

    public CustomerDTO(){
    }

    public CustomerDTO(String customerId, BigDecimal totalCashback, BigDecimal currentBalance) {
        this.customerId = customerId;
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getTotalCashback() {
        return totalCashback;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setTotalCashback(BigDecimal totalCashback) {
        this.totalCashback = totalCashback;
    }
}
