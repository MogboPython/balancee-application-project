package com.example.balancee_rewards.repository;

import com.example.balancee_rewards.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}