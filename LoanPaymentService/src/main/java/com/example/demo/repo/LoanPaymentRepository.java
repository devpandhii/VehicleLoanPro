package com.example.demo.repo;

import com.example.demo.entity.LoanPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Long> {
    List<LoanPayment> findByApplicationIdOrderByMonthPaidAsc(Integer applicationId);
}
