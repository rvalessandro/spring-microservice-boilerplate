package com.systeric.springmicroserviceboilerplate.foundation.configs.data;

import com.systeric.springmicroserviceboilerplate.foundation.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
public class TenantContext {

    private static final ThreadLocal<String> tenantId = new ThreadLocal<>();

    private static final ThreadLocal<String> userId = new ThreadLocal<>();

    public static String getTenantId() {
        return tenantId.get();
    }

    public static void setTenantId(String id) throws ValidationException {
        Optional<TenantsEnum> currentTenant = Arrays.stream(TenantsEnum.values())
                .filter(tenantsEnum -> tenantsEnum.toString().equals(id))
                .findFirst();

        if (currentTenant.isEmpty()) throw new ValidationException("Invalid Tenant!");

        tenantId.set(currentTenant.get().toString());
    }

    public static String getUserId() {
        return userId.get();
    }

    public static void setUserId(String id) {
        userId.set(id);
    }

    public static void clearAll() {
        tenantId.set(null);
        userId.set(null);
    }
}
