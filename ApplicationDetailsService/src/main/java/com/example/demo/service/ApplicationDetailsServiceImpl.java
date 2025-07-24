package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.ApplicationDetails;
import com.example.demo.repo.ApplicationDetailsRepository;

@Service
public class ApplicationDetailsServiceImpl implements ApplicationDetailsService {

    @Autowired
    private ApplicationDetailsRepository repository;

    @Override
    public void save(ApplicationDetails appDetails) {
        repository.save(appDetails);
    }

    @Override
    public ApplicationDetails find(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ApplicationDetails> findAll() {
        return repository.findAll();
    }
}
