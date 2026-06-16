package com.prasanth.SaaS_multitenant_System.dto;

import lombok.Data;

@Data
public class ProjectRequest {
    private String projectName;

    private Integer progress;

    private Integer daysRemaining;

    private Integer teamMembers;

    private Integer pendingTasks;

    private Long tenantId;
}
