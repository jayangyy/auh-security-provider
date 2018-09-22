/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.interger;

import com.kcframework.auhsecurityprovider.config.EduAccessDecisionManager;
import com.kcframework.auhsecurityprovider.config.EduInvocationSecurityMetadataSourceService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jayang 拦截过滤器 访问url时，会被AbstractSecurityInterceptor拦截器拦截，
 * 然后调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限，
 * 再调用授权管理器AccessDecisionManager鉴权。
 */
@Component
public final class EduFilterSecurityInterceptor extends AbstractSecurityInterceptor
        implements Filter {

    // @Autowired
    // private EduAccessDecisionManager accessManage;
    //@Autowired
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Autowired
    public EduFilterSecurityInterceptor(EduAccessDecisionManager accmana, EduInvocationSecurityMetadataSourceService tsource) {
        this.setAccessDecisionManager(accmana);
        this.setSecurityMetadataSource(tsource);
    }
    
//    /**
//     *
//     * @param accessDecisionManager
//     */
//    @Override
//    public AccessDecisionManager getAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
//        return accessManage;
//    }
//    
//    /**
//     *
//     * @param accessDecisionManager
//     */
//    @Override
//    public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
//        super.setAccessDecisionManager(accessManage);
//    }
//    

    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
        // this.setAccessDecisionManager(accessDecisionManager);
        return securityMetadataSource;
    }

    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        FilterInvocation fi = new FilterInvocation(request, response, chain);
        Invoke(fi);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        /// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Invoke(FilterInvocation fi) throws IOException,
            ServletException {
        InterceptorStatusToken token = super.beforeInvocation(fi);
        try {
            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        } finally {
            super.afterInvocation(token, null);
        }
    }
}
