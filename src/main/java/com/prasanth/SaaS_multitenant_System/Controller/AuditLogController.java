package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Model.AuditLog;
import com.prasanth.SaaS_multitenant_System.Service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {
    private final AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> getAllLogs() {
        return auditLogService.getAllLogs();
    }

    @GetMapping("/{id}")
    public AuditLog getLogById(@PathVariable Long id) {
        return auditLogService.getLogById(id);
    }
}
