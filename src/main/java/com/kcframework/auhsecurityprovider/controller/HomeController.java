/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.controller;

import com.kcframework.auhsecurityprovider.domains.EduUser;
import com.kcframework.auhsecurityprovider.services.BaseResourcesService;
import com.kcframework.auhsecurityprovider.services.BaseRoleService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jayang
 */
@RestController
public class HomeController extends BaseController {

    @Autowired
    private BaseRoleService baseRoleService;

    @Autowired
    protected BaseResourcesService baseMenuService;
    /**
     * 获取用户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/login.ftl1")
    public ModelAndView select(HttpServletRequest request) {

       // EduUser baseUser = getCurrentUser();
       // request.setAttribute("userInfo", baseUser);
    //    request.setAttribute("roleList", baseRoleService.selectRolesByUserId(baseUser.getUsername()));
     //   request.setAttribute("menuList", baseMenuService.getResourceByUserId(baseUser.getUsername()));
        return new ModelAndView("/login.ftl");
    }
}
