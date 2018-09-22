/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author jayan 自定义登陆FILTER
 */
public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {

//    @Resource(name = "sessionRegistry")
//    SessionRegistry ress;
//    @Resource(name = "oidMap")
//    java.util.HashMap oidMap;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

//         if (!request.getMethod().equals("POST")) {
//         throw new AuthenticationServiceException(
//         "Authentication method not supported: "
//         + request.getMethod());
//         }
//        String username = null;
//        String password = "admin";
//        String redirectUrl = null;
//        String redirectPid = "";
//        String childPid = "";
//        String resPid = null;
//        String oid = "";
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        //是否切换上级单位身份
        String isBackcom = "";
//        Map<String, String> params = ProcessParams(request.getQueryString());
//        if (!params.isEmpty()) {
//            username = params.get("UserPID");
//            redirectUrl = params.get("returnurl");
//            oid = params.get("Oid");
//            redirectPid = params.get("ResPid");
//            childPid = params.get("redicturl");
//            isBackcom = params.get("isBackcom");
//        }
//        oidMap.put(username, oid);
//        oidMap.put(username + "resPid", redirectPid);
//        oidMap.put(username + "redicturl", childPid);
//        oidMap.put(username + "sredicturl", redirectUrl);
//        oidMap.put(username + "isbackcom", isBackcom);
//        oidMap.put(username+"querystr",params.get("queryStr"));
//        System.out
//                .println(username);
//        System.out
//                .println(redirectUrl);
        if (username == null) {
            throw new UsernameNotFoundException("用户参数不能为空,请重新登录!");
        }
        if (username.length() == 0) {
            throw new UsernameNotFoundException("用户参数不能为空,重新登录!");
        }
//        //自定义回调URL，若存在则放入Session  
//        if (redirectUrl != null && !"".equals(redirectUrl)) {
//            request.getSession().setAttribute("callRediretUrl", redirectUrl);
//        }

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
    ///获取URL参数

    private Map<String, String> ProcessParams(String queryString) {
        Map<String, String> params = new HashMap<String, String>();
        try {
            if (queryString != null) {
                if (queryString.length() > 0) {
                    String[] queryArray = new String(Base64.decodeBase64(queryString), "utf-8").split("&");
                    for (String item : queryArray) {
                        String[] itemArray = item.split("=");
                        params.put(itemArray[0], itemArray[1]);
                    }
                    System.out.print((new String(Base64.decodeBase64(queryString), "utf-8") + "&isBackcom=123"));
                    params.put("queryStr", Base64.encodeBase64String((new String(Base64.decodeBase64(queryString), "utf-8") + "&isBackcom=123").getBytes("utf-8")));
                }
            }
        } catch (Throwable ex) {
            Logger.getLogger(CustomLoginFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return params;
    }
}
