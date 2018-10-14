/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.controller;

import java.security.Principal;
import javax.annotation.Resource;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jayan
 */
@RestController
public class UserController {

////    @Autowired
////    @Qualifier("redisTokenStore")
//    @Resource(name = "redisTokenStore")
//    private TokenStore tokenStore;
//
//    @GetMapping("/user")
//    public Principal user(Principal user) {
//        return user;
//    }
//
//    @RequestMapping("/oauth/remove_token")
//    public void removeToken(@RequestParam("token") String token) {
//
//        if (token != null) {
//            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
//            tokenStore.removeAccessToken(accessToken);
//        } else {
//            //return new Result(ResultEnum.TOKEN_MISS);
//        }
//
//        //return Result.returnOk();
//    }

}
