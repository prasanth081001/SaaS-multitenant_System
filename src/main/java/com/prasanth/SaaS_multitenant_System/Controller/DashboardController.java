package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Service.DashboardService;
import com.prasanth.SaaS_multitenant_System.dto.DashboardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService service;
    @GetMapping
    public DashboardResponse dashboard(){
        return service.getDashboard();
    }
}
