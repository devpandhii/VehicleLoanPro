package com.example.demo.service;

import com.example.demo.entity.ApplicationDetails;
import java.util.List;

public interface ApplicationDetailsService {

    // Save a new ApplicationDetails record
    void save(ApplicationDetails appDetails);

    // Find a record by ID
    ApplicationDetails find(Long id);

    // Get all ApplicationDetails records
    List<ApplicationDetails> findAll();
}
