/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.mappers;

import com.kcframework.auhsecurityprovider.domains.Resource;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Jayang
 */
@org.apache.ibatis.annotations.Mapper
public interface BaseResourceMapper extends Mapper<Resource> {

    @Select("select S.* from demands_roles R  join demands_res_roles O on O.roleid=R.roleid join demands_resources S on S.res_id=O.res_id   where R.roleid=#{roleid}")
    public List<Resource> getResourceByRole(String roleid);

    @Select("select S.* from demands_roles R  join demands_res_roles O on O.roleid=R.roleid join demands_resources S on S.res_id=O.res_id   where R.rolename=#{rolename}")
    public List<Resource> getResourceByRoleName(String rolename);

    @Select("select S.* from demands_roles R  join demands_res_roles O on O.roleid=R.roleid join demands_resources S on S.res_id=O.res_id  join demands_user_roles u on r.roleid=u.roleid join demands_users q on q.user_code=u.user_code where q.user_code=#{userId}")
    public List<Resource> getResourceByUserId(String userId);

}
