package com.example.balancee_rewards.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String id) {
        super("Could not find customer with id: " + id);
    }
}
