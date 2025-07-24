package com.example.demo.service;

import com.example.demo.entity.LoanCustomer;

import java.util.List;

public interface LoanCustomerService {
    void save(LoanCustomer customer);
    LoanCustomer findById(int id);
    List<LoanCustomer> findAll();
    void deleteById(int id);

    boolean emailExists(String email); // ✅ New method
}
