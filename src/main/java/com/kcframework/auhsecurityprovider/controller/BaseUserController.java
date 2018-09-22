package com.kcframework.auhsecurityprovider.controller;

import com.kcframework.auhsecurityprovider.domains.EduUser;
import com.kcframework.auhsecurityprovider.services.BaseResourcesService;
import com.kcframework.auhsecurityprovider.services.BaseRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fp295 on 2018/4/7.
 */
@Controller
public class BaseUserController extends BaseController {

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
    @RequestMapping("/index.ftl")
    public ModelAndView select(HttpServletRequest request) {

        //EduUser baseUser = getCurrentUser();
       // request.setAttribute("userInfo", baseUser);
       // /request.setAttribute("roleList", baseRoleService.selectRolesByUserId(baseUser.getUsername()));
        //request.setAttribute("menuList", baseMenuService.getResourceByUserId(baseUser.getUsername()));
        return new ModelAndView("login.ftl");
    }

}
