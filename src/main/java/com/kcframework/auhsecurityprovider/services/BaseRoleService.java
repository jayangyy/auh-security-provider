/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.services;

import com.kcframework.auhsecurityprovider.domains.Role;
import com.kcframework.auhsecurityprovider.mappers.BaseRoleMapper;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jayang
 */
@Service
public class BaseRoleService  extends BaseService<Role> {

    /**
     * 根据用户查询角色
     * @param userId
     * @return
     */
    public List<Role> selectRolesByUserId(String userId) {
        return ((BaseRoleMapper)mapper).getRoleByUserId(userId);
    }

    /**
     * 根据菜单查询角色
     * @param menuId
     * @return
     */
    public List<Role> selectRolesByMenuId(String menuId) {
        return ((BaseRoleMapper)mapper).getRoleByUserId(menuId);
    }
}
