package com.prasanth.SaaS_multitenant_System.dto;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String role;
    private Long tenantId;
}
