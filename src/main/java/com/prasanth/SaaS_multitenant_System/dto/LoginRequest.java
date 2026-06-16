package com.prasanth.SaaS_multitenant_System.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
