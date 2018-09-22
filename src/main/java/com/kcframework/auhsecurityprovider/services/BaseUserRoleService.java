/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.services;

import com.kcframework.auhsecurityprovider.domains.UserRole;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 *
 * @author Jayang
 */
@Service
public class BaseUserRoleService extends BaseService<UserRole> {

    /**
     * 保存用户角色
     *
     * @param baseUserRoleList
     */
    @Transactional
    public void saveUserRole(List<UserRole> baseUserRoleList) {
        if (baseUserRoleList.size() > 0 && !StringUtils.isEmpty(baseUserRoleList.get(0).getRoleid())) {
            UserRole userRole = new UserRole();
            userRole.setRoleid(baseUserRoleList.get(0).getRoleid());
            mapper.delete(userRole);
            baseUserRoleList.forEach(it -> {
//                it.setId(UUID.uuid32());
                insertSelective(it);
            });
        }
    }
}
