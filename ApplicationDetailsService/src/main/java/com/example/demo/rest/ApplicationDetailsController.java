package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.service.ApplicationDetailsService;
import com.example.demo.entity.ApplicationDetails;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/application-details")
public class ApplicationDetailsController {

    @Autowired
    private ApplicationDetailsService service;

    @PostMapping(value = "/", consumes = "application/json")
    public String saveApplicationDetails(@RequestBody ApplicationDetails appDetails) {
        service.save(appDetails);
        return "Application details saved.";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ApplicationDetails getApplicationDetails(@PathVariable Long id) {
        return service.find(id);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<ApplicationDetails> getAllApplicationDetails() {
        return service.findAll();
    }
}
