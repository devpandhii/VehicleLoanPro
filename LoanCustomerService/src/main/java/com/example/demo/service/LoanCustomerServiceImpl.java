package com.example.demo.service;

import com.example.demo.entity.LoanCustomer;
import com.example.demo.repo.LoanCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanCustomerServiceImpl implements LoanCustomerService {

    @Autowired
    private LoanCustomerRepository repository;

    @Override
    public void save(LoanCustomer customer) {
        // ✅ Hash the password before saving
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        customer.setPassword(encoder.encode(customer.getPassword()));
        repository.save(customer);
    }

    @Override
    public LoanCustomer findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<LoanCustomer> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean emailExists(String email) {
        return repository.findByEmail(email).isPresent();
    }
}
