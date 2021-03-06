///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.kcframework.auhsecurityprovider.config;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//import javax.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
//
///**
// * @ClassName: AllowedMethodConfig
// * @Description: OAUTH2支持GET请求
// * @author fushihua
// * @date 2017年11月13日 下午3:03:07
// */
//@Configuration
//public class AllowedMethodConfig {
//
//    @Autowired
//    private TokenEndpoint tokenEndpoint;
//
//    @PostConstruct
//    public void reconfigure() {
//        Set<HttpMethod> allowedMethods
//                = new HashSet<>(Arrays.asList(HttpMethod.GET, HttpMethod.POST));
//        tokenEndpoint.setAllowedRequestMethods(allowedMethods);
//    }
//}
