package com.prasanth.SaaS_multitenant_System.Repository;

import com.prasanth.SaaS_multitenant_System.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findByRiskLevel(String riskLevel);
    List<Project> findByTenantId(Long tenantId);
}
