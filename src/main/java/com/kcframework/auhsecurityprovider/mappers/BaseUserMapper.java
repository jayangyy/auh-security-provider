package com.kcframework.auhsecurityprovider.mappers;

import com.kcframework.auhsecurityprovider.domains.EduUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface BaseUserMapper extends Mapper<EduUser> {

    @Select("select *,user_name as username,user_password as password from demands_users where user_name=#{name}")
    public EduUser getUserByName(String name);
}
