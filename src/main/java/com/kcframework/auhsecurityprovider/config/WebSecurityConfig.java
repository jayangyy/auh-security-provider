package com.kcframework.auhsecurityprovider.config;

import com.kcframework.auhsecurityprovider.filter.CustomLoginFilter;
import com.kcframework.auhsecurityprovider.handler.CustomLoginAuthEntryPoint;
import com.kcframework.auhsecurityprovider.handler.CustomLoginAuthFailureHandler;
import com.kcframework.auhsecurityprovider.handler.CustomLoginAuthSuccessHandler;
import com.kcframework.auhsecurityprovider.handler.CustomLogoutSuccessHandler;
import com.kcframework.auhsecurityprovider.interger.EduFilterSecurityInterceptor;
import com.kcframework.auhsecurityprovider.services.EduUserDetailsService;
import com.kcframework.auhsecurityprovider.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring-security配置
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EduUserDetailsService userDetailsService;
    @Autowired
    private EduInvocationSecurityMetadataSourceService metaService;
    @Autowired
    private PropertySource propertySourceBean;
    @Autowired
    private EduFilterSecurityInterceptor inger;
    @Autowired
    private EduAccessDecisionManager accmanage;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("权限框架配置");

        String[] paths = null;
        //设置不拦截
        if (propertySourceBean.getProperty("security.ignoring") != null) {
            paths = propertySourceBean.getProperty("security.ignoring").toString().split(",");
            paths = StringUtil.clearSpace(paths);
        }
        //设置过滤器
        http.authorizeRequests().antMatchers(paths).permitAll()
                .and()
                .httpBasic()
                .authenticationEntryPoint(getCustomLoginAuthEntryPoint())
                .and()
                .addFilterAt(getCustomLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAt(inger, FilterSecurityInterceptor.class)
                .logout().logoutSuccessHandler(getCustomLogoutSuccessHandler())
                .and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login.ftl1")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll();
        logger.debug("配置忽略验证url");
    }

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getDaoAuthenticationProvider());
    }

    /**
     * spring security 配置
     *
     * @return
     */
    @Bean
    public CustomLoginAuthEntryPoint getCustomLoginAuthEntryPoint() {
        return new CustomLoginAuthEntryPoint();
    }

    /**
     * 用户验证 不一樣
     *
     * @return
     */
    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setHideUserNotFoundExceptions(false);
        //  provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    /**
     * 登陆
     *
     * @return
     */
    @Bean
    public CustomLoginFilter getCustomLoginFilter() {
        CustomLoginFilter filter = new CustomLoginFilter();
        try {
            filter.setAuthenticationManager(this.authenticationManagerBean());
        } catch (Exception e) {
            e.printStackTrace();
        }
        filter.setAuthenticationSuccessHandler(getCustomLoginAuthSuccessHandler());
        filter.setAuthenticationFailureHandler(getCustomLoginAuthFailureHandler());

        return filter;
    }

    @Bean
    public CustomLoginAuthSuccessHandler getCustomLoginAuthSuccessHandler() {
        CustomLoginAuthSuccessHandler handler = new CustomLoginAuthSuccessHandler();
        if (propertySourceBean.getProperty("security.successUrl") != null) {
            handler.setAuthSuccessUrl(propertySourceBean.getProperty("security.successUrl").toString());
        }
        return handler;
    }

    @Bean
    public CustomLoginAuthFailureHandler getCustomLoginAuthFailureHandler() {
        return new CustomLoginAuthFailureHandler();
    }

    /**
     * 登出
     *
     * @return
     */
    @Bean
    public CustomLogoutSuccessHandler getCustomLogoutSuccessHandler() {
        CustomLogoutSuccessHandler handler = new CustomLogoutSuccessHandler();
        if (propertySourceBean.getProperty("security.logoutSuccessUrl") != null) {
            handler.setLoginUrl(propertySourceBean.getProperty("security.logoutSuccessUrl").toString());
        }
        return handler;
    }

//    @Bean
//    public EduAccessDecisionManager getCustomAccessDecisionManager() {
//        return new EduAccessDecisionManager();
//    }
//    /**
//     * 过滤器
//     *
//     * @return
//     */
//    @Bean
//    public EduFilterSecurityInterceptor getCustomSecurityInterceptor() {
//        EduFilterSecurityInterceptor interceptor = new EduFilterSecurityInterceptor();
//
//        //interceptor.setSecurityMetadataSource(new EduInvocationSecurityMetadataSourceService());
//        //  System.out.println(accessManage.toString());
//        interceptor.setAccessDecisionManager(accmanage);
//        try {
//            interceptor.setAuthenticationManager(this.authenticationManagerBean());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return interceptor;
//    }
//    @Bean
//    public EduInvocationSecurityMetadataSourceService getCustomMetadataSourceService() {
//        EduInvocationSecurityMetadataSourceService sourceService = new EduInvocationSecurityMetadataSourceService();
//        if (propertySourceBean.getProperty("security.successUrl") != null) {
//            sourceService.setIndexUrl(propertySourceBean.getProperty("security.successUrl").toString());
//        }
//        return sourceService;
//    }
}
