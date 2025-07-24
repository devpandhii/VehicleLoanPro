package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

import com.example.demo.service.ApplicationStatusService;
import com.example.demo.dto.ApplicationStatsDTO;
import com.example.demo.entity.ApplicationStatus;
import com.example.demo.repo.ApplicationStatusRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/application-status")
public class ApplicationStatusController {

    @Autowired
    private ApplicationStatusService service;

    @Autowired
    private ApplicationStatusRepository repository;

    // ✅ Save new application with applied date
    @PostMapping(value = "/", consumes = "application/json")
    public String saveApplicationStatus(@RequestBody ApplicationStatus appStatus) {
        appStatus.setApplicationDate(new Date()); // ✅ Set current date
        service.save(appStatus);
        return "Application status saved.";
    }

    // ✅ Get application by ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public ApplicationStatus getApplicationStatus(@PathVariable int id) {
        return service.find(id);
    }

    // ✅ Get all applications
    @GetMapping(value = "/all", produces = "application/json")
    public List<ApplicationStatus> getAllApplicationStatus() {
        return service.findAll();
    }

    // ✅ Approve application
    @PutMapping("/approve/{id}")
    public String approveApplication(@PathVariable int id) {
        ApplicationStatus status = service.find(id);
        if (status != null) {
            status.setApplicationStatus("Approved");
            status.setAdminVerified("Yes");
            service.save(status);
            return "Application ID " + id + " approved successfully.";
        } else {
            return "Application ID " + id + " not found.";
        }
    }

    // ✅ Reject application
    @PutMapping("/reject/{id}")
    public String rejectApplication(@PathVariable int id) {
        ApplicationStatus status = service.find(id);
        if (status != null) {
            status.setApplicationStatus("Rejected");
            status.setAdminVerified("Yes");
            service.save(status);
            return "Application ID " + id + " rejected.";
        } else {
            return "Application ID " + id + " not found.";
        }
    }

    // ✅ Get latest application by email
    @GetMapping("/email/{email}")
    public ApplicationStatus getByEmail(@PathVariable String email) {
        return repository.findLatestByEmail(email); // ✅ Oracle-safe
    }
    
    @GetMapping("/user/{email}")
    public List<ApplicationStatus> getApplicationsByEmail(@PathVariable String email) {
        return repository.findAllByEmailIgnoreCaseOrderByApplicationIdDesc(email);
    }
    
    @GetMapping("/stats")
    public ResponseEntity<ApplicationStatsDTO> getApplicationStats() {
        return ResponseEntity.ok(service.getStats());
    }

}
