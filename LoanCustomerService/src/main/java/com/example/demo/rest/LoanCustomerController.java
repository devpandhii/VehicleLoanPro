package com.example.demo.rest;

import com.example.demo.entity.LoanCustomer;
import com.example.demo.service.LoanCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/loan-customer")
public class LoanCustomerController {

    @Autowired
    private LoanCustomerService service;
    
    

    // ✅ Save new customer with password and email uniqueness check
    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<String> saveCustomer(@RequestBody LoanCustomer customer) {
        if (service.emailExists(customer.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
        }

        try {
            service.save(customer);
            return ResponseEntity.ok("Customer saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save customer.");
        }
    }
    
    

    @GetMapping("/{id}")
    public LoanCustomer getCustomer(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<LoanCustomer> getAllCustomers() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        service.deleteById(id);
        return "Customer deleted with ID: " + id;
    }
}
