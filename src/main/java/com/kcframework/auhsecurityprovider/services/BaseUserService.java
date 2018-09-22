/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.services;

import com.kcframework.auhsecurityprovider.domains.EduUser;
import com.kcframework.auhsecurityprovider.mappers.BaseUserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jayang
 */
@Service
public class BaseUserService extends BaseService<EduUser> {

    @Autowired
    private BaseUserRoleService baseUserRoleService;

    public EduUser getUserByName(String name) {
        return ((BaseUserMapper) mapper).getUserByName(name);
    }

    /**
     * 批量重置密码
     *
     * @param record
     * @param newPassword
     */
    @Transactional
    public void resetPassword(List<EduUser> record, String newPassword) {
        record.forEach(e -> {
            EduUser baseUser = new EduUser();
//            baseUser.setId(e.getId());
//            baseUser.setPassword(new BCryptPasswordEncoder(6).encode(newPassword));
//            baseUser.setUpdateDate(new Date());
//            updateByPrimaryKeySelective(baseUser);
        });
    }

//    /**
//     * 删除用户
//     * @param record
//     */
//    @Transactional
//    public void deleteBatch(List<BaseUser> record) {
//        record.forEach(e -> {
//            Example example = new Example(BaseUserRole.class);
//            example.createCriteria().andEqualTo("userId", e.getId());
//            baseUserRoleService.deleteByExample(example);
//            deleteByPrimaryKey(e);
//        });
//    }
}
