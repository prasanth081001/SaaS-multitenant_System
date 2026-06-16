package com.prasanth.SaaS_multitenant_System.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private Integer progress;

    private Integer daysRemaining;

    private String riskLevel;

    private Integer healthScore;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
}