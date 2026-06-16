package com.prasanth.SaaS_multitenant_System.Tenant;

public class TenantContext {
    private static final ThreadLocal<Long> TENANT =
            new ThreadLocal<>();

    public static void setTenant(Long tenantId) {
        TENANT.set(tenantId);
    }

    public static Long getTenant() {
        return TENANT.get();
    }

    public static void clear() {
        TENANT.remove();
    }
}
