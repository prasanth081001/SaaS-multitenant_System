package com.prasanth.SaaS_multitenant_System.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String role;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;
}
