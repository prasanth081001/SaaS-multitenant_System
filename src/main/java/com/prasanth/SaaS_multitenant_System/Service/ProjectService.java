package com.prasanth.SaaS_multitenant_System.Service;

import com.prasanth.SaaS_multitenant_System.Model.AuditLog;
import com.prasanth.SaaS_multitenant_System.Model.Project;
import com.prasanth.SaaS_multitenant_System.Model.Tenant;
import com.prasanth.SaaS_multitenant_System.Repository.AuditLogRepository;
import com.prasanth.SaaS_multitenant_System.Repository.NotificationRepository;
import com.prasanth.SaaS_multitenant_System.Repository.ProjectRepository;
import com.prasanth.SaaS_multitenant_System.Repository.TenantRepository;
import com.prasanth.SaaS_multitenant_System.dto.ProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final AuditLogRepository auditLogRepository;

    private final TenantRepository tenantRepository;
private final NotificationService notificationService;
    private final RiskPredictionEngine riskEngine;

    private final HealthScoreEngine healthEngine;

    public Project createProject(
            ProjectRequest request){



        Tenant tenant =
                tenantRepository.findById(
                                request.getTenantId())
                        .orElseThrow();

        String risk =
                riskEngine.calculateRisk(
                        request.getProgress(),
                        request.getDaysRemaining());

        Integer score =
                healthEngine.calculateScore(
                        request.getProgress(),
                        request.getTeamMembers(),
                        request.getPendingTasks());
        if("HIGH".equals(risk)){

            notificationService.createNotification(
                    tenant,
                    "High Risk Project : "
                            + request.getProjectName());
        }
        AuditLog auditLog = new AuditLog();

        auditLog.setAction("PROJECT_CREATED");

        auditLog.setAction(
                "Project Created : "
                        + request.getProjectName());

        auditLogRepository.save(auditLog);

        Project project =
                Project.builder()
                        .projectName(
                                request.getProjectName())
                        .progress(
                                request.getProgress())
                        .daysRemaining(
                                request.getDaysRemaining())
                        .riskLevel(risk)
                        .healthScore(score)
                        .tenant(tenant)
                        .build();

        return projectRepository.save(
                project);
    }

    public List<Project> getProjects(){

        return projectRepository.findAll();
    }

    public Project getProject(Long id){

        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Project Not Found"));
    }

    public Project updateProject(
            Long id,
            ProjectRequest request){

        Project project =
                getProject(id);

        project.setProjectName(
                request.getProjectName());

        project.setProgress(
                request.getProgress());

        project.setDaysRemaining(
                request.getDaysRemaining());

        return projectRepository.save(
                project);
    }

    public void deleteProject(Long id){

        projectRepository.deleteById(id);
    }

    public List<Project> getHighRiskProjects(){

        return projectRepository
                .findByRiskLevel("HIGH");
    }
}
