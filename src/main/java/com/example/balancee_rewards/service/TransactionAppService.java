package com.example.balancee_rewards.service;

import com.example.balancee_rewards.model.*;
import com.example.balancee_rewards.repository.*;
import com.example.balancee_rewards.dto.CashbackTransactionDTO;
import com.example.balancee_rewards.exception.*;
import com.example.balancee_rewards.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionAppService {

    private final CustomerRepository customerRepository;
    private final CashbackTransactionRepository cashbackTransactionRepository;

    @Autowired
    public TransactionAppService(CustomerRepository customerRepository, CashbackTransactionRepository cashbackTransactionRepository) {
        this.customerRepository = customerRepository;
        this.cashbackTransactionRepository = cashbackTransactionRepository;
    }

    public CashbackTransaction saveTransaction(CashbackTransaction transaction) {
 
        // BT - Balancee Transaction
        String ID = "BT_" + IdGenerator.generateId(); 

        while(customerRepository.existsById(ID)) {
            ID = "BT_" + IdGenerator.generateId(); 
        }
        
        transaction.setTransactionId(ID);
        return cashbackTransactionRepository.save(transaction);
    }

    @Transactional(readOnly = true)
    public List<CashbackTransaction> getCashbackHistory(String customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }
        return cashbackTransactionRepository.findByCustomerCustomerId(customerId);
    }

    @Transactional(readOnly = true)
    public List<CashbackTransactionDTO> findByCustomerId(String customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new CustomerNotFoundException(customerId);
        }
        return cashbackTransactionRepository.findByCustomerCustomerId(customerId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CashbackTransactionDTO convertToDTO(CashbackTransaction transaction) {
        CashbackTransactionDTO dto = new CashbackTransactionDTO();
        dto.setTransactionId(transaction.getTransactionId());
        dto.setAmountEarned(transaction.getAmountEarned());
        dto.setTransactionDate(transaction.getTransactionDate());
        dto.setCustomerId(transaction.getCustomer().getCustomerId());
        return dto;
    }
}