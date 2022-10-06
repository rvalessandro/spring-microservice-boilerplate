package com.systeric.springmicroserviceboilerplate.infrastructure.producers.data;

import com.systeric.springmicroserviceboilerplate.foundation.configs.constant.ContextConstants;
import com.systeric.springmicroserviceboilerplate.foundation.configs.data.TenantContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.ThreadContext;

@AllArgsConstructor
@Getter
@Setter
public class Context {
    public String tenantId;
    public String userId;

    public Context(){
        this.tenantId = TenantContext.getTenantId();
        this.userId = TenantContext.getUserId();
    }
}
