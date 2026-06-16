package com.prasanth.SaaS_multitenant_System.Service;

import com.prasanth.SaaS_multitenant_System.Model.AuditLog;
import com.prasanth.SaaS_multitenant_System.Repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService {
    private final AuditLogRepository repository;

    public void saveLog(
            String username,
            String action){

        AuditLog log =
                AuditLog.builder()
                        .username(username)
                        .action(action)
                        .actionTime(
                                LocalDateTime.now())
                        .build();

        repository.save(log);
    }

    public List<AuditLog> getAllLogs(){

        return repository.findAll();
    }
    public AuditLog getLogById(Long id){
        return repository.findById(id).orElseThrow(()->new RuntimeException("Audit log not found"));
    }
}
