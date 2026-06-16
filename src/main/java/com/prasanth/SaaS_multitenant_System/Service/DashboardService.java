package com.prasanth.SaaS_multitenant_System.Service;

import com.prasanth.SaaS_multitenant_System.Repository.ProjectRepository;
import com.prasanth.SaaS_multitenant_System.dto.DashboardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {
    private final ProjectRepository repository;

    public DashboardResponse getDashboard(){

        long total =
                repository.count();

        long high =
                repository
                        .findByRiskLevel("HIGH")
                        .size();

        long medium =
                repository
                        .findByRiskLevel("MEDIUM")
                        .size();

        long low =
                repository
                        .findByRiskLevel("LOW")
                        .size();

        return DashboardResponse.builder()
                .totalProjects(total)
                .highRiskProjects(high)
                .mediumRiskProjects(medium)
                .lowRiskProjects(low)
                .build();
    }
}
