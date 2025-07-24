package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApplicationStatsDTO;
import com.example.demo.entity.ApplicationStatus;
import com.example.demo.repo.ApplicationStatusRepository;
import java.util.List;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService {

    @Autowired
    private ApplicationStatusRepository repository;

    @Override
    public void save(ApplicationStatus appStatus) {
        repository.save(appStatus);
    }

    @Override
    public ApplicationStatus find(int id) {
        return repository.findById(id).orElse(null);
    }

    // ---- NEW METHOD ----
    @Override
    public List<ApplicationStatus> findAll() {
        return repository.findAll();
    }
    
    public ApplicationStatsDTO getStats() {
        List<ApplicationStatus> all = repository.findAll();
        ApplicationStatsDTO stats = new ApplicationStatsDTO();

        stats.setTotalApplications(all.size());

        long approved = all.stream()
            .filter(app -> "Approved".equalsIgnoreCase(app.getApplicationStatus()))
            .count();
        stats.setApprovedLoans(approved);

        double totalDisbursed = all.stream()
            .filter(app -> "Approved".equalsIgnoreCase(app.getApplicationStatus()))
            .mapToDouble(ApplicationStatus::getLoanAmount)
            .sum();
        stats.setTotalDisbursed(totalDisbursed);

        long users = all.stream()
            .map(ApplicationStatus::getApplicationId) // assuming userId is present
            .distinct()
            .count();
        stats.setTotalUsers(users);

        return stats;
    }
}
