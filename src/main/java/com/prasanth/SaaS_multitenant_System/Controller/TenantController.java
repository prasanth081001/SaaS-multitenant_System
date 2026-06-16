package com.prasanth.SaaS_multitenant_System.Controller;

import com.prasanth.SaaS_multitenant_System.Model.Tenant;
import com.prasanth.SaaS_multitenant_System.Service.TenantService;
import com.prasanth.SaaS_multitenant_System.dto.TenantRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {
    private final TenantService service;

    @PostMapping
    public Tenant createTenant(
            @RequestBody TenantRequest request){

        return service.createTenant(request);
    }

    @GetMapping
    public List<Tenant> getTenants(){

        return service.getAllTenants();
    }

    @GetMapping("/{id}")
    public Tenant getTenant(
            @PathVariable Long id){

        return service.getTenant(id);
    }

    @PutMapping("/{id}")
    public Tenant updateTenant(
            @PathVariable Long id,
            @RequestBody TenantRequest request){

        return service.updateTenant(
                id,
                request);
    }

    @PatchMapping("/{id}/activate")
    public String activateTenant(
            @PathVariable Long id){

        service.activateTenant(id);

        return "Tenant Activated";
    }
}
