///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.kcframework.auhsecurityprovider.resourceserver;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
///**
// *
// * @author jayan
// */
//@Configuration
//@EnableResourceServer
//public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {
////   @Autowired
////    private OAuth2ClientProperties oAuth2ClientProperties;
////
////    @Autowired
////    private AuthorizationServerProperties authorizationServerProperties;
////
////    @Bean
////    public ResourceServerTokenServices tokenServices() {
////        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
////        remoteTokenServices.setCheckTokenEndpointUrl(authorizationServerProperties.getCheckTokenAccess());
////     //   remoteTokenServices.setClientId(oAuth2ClientProperties.());
////       // remoteTokenServices.setClientSecret(oAuth2ClientProperties.getClientSecret());
////       // remoteTokenServices.setAccessTokenConverter(accessTokenConverter());
////        return remoteTokenServices;
////    }
//
////    @Override
////    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
////        super.configure(resources);
////        resources.authenticationEntryPoint(customAuthEntryPoint).accessDeniedHandler(customAccessDeniedHandler);
////    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/oauth/**").permitAll()
//                .anyRequest().authenticated();
//        ;
//    }
//
//    @Bean
//    public AccessTokenConverter accessTokenConverter() {
//        return new DefaultAccessTokenConverter();
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    //与授权服务器使用共同的密钥进行解析
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("123");
//        return converter;
//    }
//}
