package com.example.balancee_rewards.repository;

import com.example.balancee_rewards.model.CashbackTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashbackTransactionRepository extends JpaRepository<CashbackTransaction, String> {
    List<CashbackTransaction> findByCustomerCustomerId(String customerId);
}
