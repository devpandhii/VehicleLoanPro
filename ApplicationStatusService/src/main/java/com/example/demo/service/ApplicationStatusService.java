package com.example.demo.service;

import com.example.demo.dto.ApplicationStatsDTO;
import com.example.demo.entity.ApplicationStatus;
import java.util.List;

public interface ApplicationStatusService {
    void save(ApplicationStatus appStatus);
    ApplicationStatus find(int id);
    List<ApplicationStatus> findAll();
    ApplicationStatsDTO getStats();// <---- NEW
}
