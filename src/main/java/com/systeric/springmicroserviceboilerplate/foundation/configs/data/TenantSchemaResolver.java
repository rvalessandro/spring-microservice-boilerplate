package com.systeric.springmicroserviceboilerplate.foundation.configs.data;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getTenantId();

        return tenantId == null
                ? ""
                : tenantId;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
