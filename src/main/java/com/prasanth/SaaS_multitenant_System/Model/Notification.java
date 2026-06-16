package com.prasanth.SaaS_multitenant_System.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Boolean readStatus;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
}
