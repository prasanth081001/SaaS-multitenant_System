package com.prasanth.SaaS_multitenant_System.Repository;

import com.prasanth.SaaS_multitenant_System.Model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
    List<AuditLog> findByUsername(String username);
}
