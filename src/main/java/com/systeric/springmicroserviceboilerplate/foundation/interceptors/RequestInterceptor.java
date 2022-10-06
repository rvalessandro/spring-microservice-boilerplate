package com.systeric.springmicroserviceboilerplate.foundation.interceptors;

import com.systeric.springmicroserviceboilerplate.foundation.configs.data.TenantContext;
import com.systeric.springmicroserviceboilerplate.foundation.configs.data.TenantsEnum;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String tenantID = null;

        String host = request.getServerName();
        TenantsEnum hostTenant = TenantsEnum.get(host.split("\\.")[0]);

        if (hostTenant != null) {  // checking using url domain
            tenantID = hostTenant.name();
        } else { // checking header for tenant ID
            // TODO Disable on production
            tenantID = request.getHeader("TenantID");
        }

        TenantContext.setTenantId(tenantID);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView
    ) throws Exception {
        ThreadContext.clearAll();
        TenantContext.clearAll();
    }

}
