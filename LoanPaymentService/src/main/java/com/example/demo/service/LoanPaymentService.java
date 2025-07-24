package com.example.demo.service;

import com.example.demo.entity.LoanPayment;
import com.example.demo.repo.LoanPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanPaymentService {

    @Autowired
    private LoanPaymentRepository repo;

    public LoanPayment save(LoanPayment payment) {
        return repo.save(payment);
    }

    public List<LoanPayment> getPaymentsByApplicationId(Integer applicationId) {
        return repo.findByApplicationIdOrderByMonthPaidAsc(applicationId);
    }
}
