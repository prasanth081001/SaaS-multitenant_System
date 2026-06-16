package com.prasanth.SaaS_multitenant_System.Service;

import com.prasanth.SaaS_multitenant_System.Model.Tenant;
import com.prasanth.SaaS_multitenant_System.Repository.TenantRepository;
import com.prasanth.SaaS_multitenant_System.dto.TenantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TenantService {
    private final TenantRepository tenantRepository;

    public Tenant createTenant(
            TenantRequest request){

        Tenant tenant =
                Tenant.builder()
                        .tenantName(
                                request.getTenantName())
                        .status("ACTIVE")
                        .build();

        return tenantRepository.save(
                tenant);
    }

    public List<Tenant> getAllTenants(){

        return tenantRepository.findAll();
    }

    public Tenant getTenant(Long id){

        return tenantRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Tenant Not Found"));
    }

    public Tenant updateTenant(
            Long id,
            TenantRequest request){

        Tenant tenant = getTenant(id);

        tenant.setTenantName(
                request.getTenantName());

        return tenantRepository.save(
                tenant);
    }

    public void activateTenant(Long id){

        Tenant tenant = getTenant(id);

        tenant.setStatus("ACTIVE");

        tenantRepository.save(tenant);
    }
}
