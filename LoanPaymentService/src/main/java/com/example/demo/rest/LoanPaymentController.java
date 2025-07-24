package com.example.demo.rest;

import com.example.demo.entity.LoanPayment;
import com.example.demo.service.LoanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/loan-payments")
public class LoanPaymentController {

    @Autowired
    private LoanPaymentService service;

    @PostMapping
    public String payEMI(@RequestBody LoanPayment payment) {
        payment.setPaymentDate(new Date());
        payment.setStatus("Paid");
        service.save(payment);
        return "Payment of ₹" + payment.getAmountPaid() + " has been recorded.";
    }

    @GetMapping("/application/{applicationId}")
    public List<LoanPayment> getPaymentsByApplication(@PathVariable int applicationId) {
        return service.getPaymentsByApplicationId(applicationId);
    }
}
