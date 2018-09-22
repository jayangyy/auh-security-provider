package com.kcframework.auhsecurityprovider.controller;

import com.kcframework.auhsecurityprovider.domains.EduUser;
import com.kcframework.auhsecurityprovider.services.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class BaseController {

    @Autowired
    private BaseUserService baseUserService;

    /**
     * 获取当前用户
     *
     * @return
     */
    protected EduUser getCurrentUser() {
        //获取当前用户
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        //查询当前用户
        EduUser baseUser = new EduUser();
        baseUser.setUsername(userDetails.getUsername());
        baseUser = baseUserService.selectOne(baseUser);

        if (baseUser == null) {
            throw new RuntimeException("用户不存在: " + userDetails.getUsername());
        }

        return baseUser;
    }

}
