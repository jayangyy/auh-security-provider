package com.kcframework.auhsecurityprovider.mappers;

import com.kcframework.auhsecurityprovider.domains.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;

@org.apache.ibatis.annotations.Mapper
public interface BaseRoleMapper extends Mapper<Role> {

    @Select("SELECT  * from demands_roles  r join demands_user_roles s on s.roleid=r.roleid where s.user_code=#{userId}")
    List<Role> getRoleByUserId(@Param("userId") String userId);

    @Select("SELECT  * from demands_roles  r join demands_user_roles s on s.roleid=r.roleid where s.user_code=#{menuId}")
    List<Role> selectRolesByMenuId(String menuId);
}
