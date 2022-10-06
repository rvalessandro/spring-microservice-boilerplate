package com.systeric.springmicroserviceboilerplate.foundation.configs.data;

import lombok.SneakyThrows;

public class TenantAwareThread extends Thread {
    private final String tenantId;

    public TenantAwareThread(Runnable target, String tenantId) {
        super(target);
        this.tenantId = tenantId;
    }

    @SneakyThrows
    @Override
    public void run() {
        TenantContext.setTenantId(this.tenantId);
        super.run();
        TenantContext.clearAll();
    }
}