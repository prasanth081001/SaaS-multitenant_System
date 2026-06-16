package com.prasanth.SaaS_multitenant_System.dto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private Long totalProjects;

    private Long highRiskProjects;

    private Long mediumRiskProjects;

    private Long lowRiskProjects;
}