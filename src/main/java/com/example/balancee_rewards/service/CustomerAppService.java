package com.example.balancee_rewards.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.balancee_rewards.exception.CustomerNotFoundException;
import com.example.balancee_rewards.model.Customer;
import com.example.balancee_rewards.util.IdGenerator;
import com.example.balancee_rewards.repository.CustomerRepository;

@Service
public class CustomerAppService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerAppService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomerInfo(Customer customer_info) {
        
        // BC - Balancee Customer
        String ID = "BC_" + IdGenerator.generateId(); 
        
        while(customerRepository.existsById(ID)) {
            ID = "BC_" + IdGenerator.generateId(); 
        }
        
        customer_info.setCustomerId(ID);
        return customerRepository.save(customer_info);
    }

    @Transactional(readOnly = true)
    public Customer getCustomerInfo(String customerId) {
        return customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

}
