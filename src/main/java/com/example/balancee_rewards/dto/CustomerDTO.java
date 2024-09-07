package com.example.balancee_rewards.dto;

public class CustomerDTO {
    private String transactionId;
    private Double totalCashback;
    private Double currentBalance;

    public CustomerDTO(){
    }

    public CustomerDTO(String transactionId, Double totalCashback, Double currentBalance) {
        this.transactionId = transactionId;
        this.totalCashback = totalCashback;
        this.currentBalance = currentBalance;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public Double getTotalCashback() {
        return totalCashback;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setTotalCashback(Double totalCashback) {
        this.totalCashback = totalCashback;
    }
}
