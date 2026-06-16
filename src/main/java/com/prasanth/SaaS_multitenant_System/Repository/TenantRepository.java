package com.prasanth.SaaS_multitenant_System.Repository;

import com.prasanth.SaaS_multitenant_System.Model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
}
