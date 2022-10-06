package com.systeric.springmicroserviceboilerplate.foundation.configs.data;

import java.util.Arrays;
import java.util.Optional;

// Use lowercase since PostgreSQL only supports lowercase for tenant naming
// Do not use underscore '_' for tenant naming since host url local doesn't support domain with underscore
public enum TenantsEnum {
    tenant_1("tenant1"),
    tenant_2("tenant2"),
    tenant_3("tenant3");

    public final String label;

    TenantsEnum(String label) {
        this.label = label;
    }

    public static TenantsEnum get(String label) {
        return Arrays.stream(TenantsEnum.values())
                .filter(env -> env.label.equals(label))
                .findFirst().orElse(null);
    }
}
