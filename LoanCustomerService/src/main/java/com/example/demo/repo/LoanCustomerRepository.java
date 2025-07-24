package com.example.demo.repo;

import com.example.demo.entity.LoanCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanCustomerRepository extends JpaRepository<LoanCustomer, Integer> {
    Optional<LoanCustomer> findByEmail(String email); // ✅ Used for email uniqueness check
}
