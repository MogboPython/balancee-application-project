package com.example.balancee_rewards.controller;

import com.example.balancee_rewards.dto.CashbackTransactionDTO;
import com.example.balancee_rewards.exception.CustomerNotFoundException;
import com.example.balancee_rewards.model.*;
import com.example.balancee_rewards.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
@Validated
public class AppController {

    private final CustomerAppService customerAppService;
    private final TransactionAppService transactionAppService;

    @Autowired
    public AppController(CustomerAppService customerAppService, TransactionAppService transactionAppService) {
        this.customerAppService = customerAppService;
        this.transactionAppService = transactionAppService;
    }

    @PostMapping("/customer_info")
    public ResponseEntity<Customer> saveCustomerInfo(@RequestBody Customer customer_info) {
        Customer newCustomer = customerAppService.saveCustomerInfo(customer_info);
        return ResponseEntity.ok(newCustomer);
    }
    @PostMapping("/add_transaction")
    public ResponseEntity<CashbackTransaction> saveTransaction(@RequestBody CashbackTransaction transaction) {
        CashbackTransaction newTransaction = transactionAppService.saveTransaction(transaction);
        return ResponseEntity.ok(newTransaction);
    }

    @GetMapping("/balance/{id}")
    public ResponseEntity<ResponseWrapper<Object>> getCustomerBalance(@PathVariable String id) {
        try {

            Customer customerInfo = customerAppService.getCustomerInfo(id);
            ResponseWrapper<Object> response = new ResponseWrapper<>("success", customerInfo);
            return ResponseEntity.ok(response);

        } catch (CustomerNotFoundException e) {

            ResponseWrapper<Object> response = new ResponseWrapper<>("fail", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {

            ResponseWrapper<Object> response = new ResponseWrapper<>("fail", "An unexpected error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }

    // TODO: Specify how user id should be sent 
    @GetMapping("/history/{id}")
    public ResponseEntity<ResponseWrapper<Object>> getTransactionsByCustomerId(@PathVariable String id) {
        try {

            List<CashbackTransactionDTO> transactions = transactionAppService.findByCustomerId(id);
            ResponseWrapper<Object> response = new ResponseWrapper<>("success", transactions);
            return ResponseEntity.ok(response);

        } catch (CustomerNotFoundException e) {

            ResponseWrapper<Object> response = new ResponseWrapper<>("fail", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {

            ResponseWrapper<Object> response = new ResponseWrapper<>("fail", "An unexpected error occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        }
    }
}