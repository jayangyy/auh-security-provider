/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.domains;

import java.util.List;

/**
 *
 * @author Jayang
 */
public class RoleSearch extends QueryModel {

    //是否全部删除
    private String isdelall;
    //是否分配所有
    private String isalladd;
    //用户ID 集合
    private String uids;
    //角色ID
    private String roleid;
    //是否系统管理员
    private Boolean isAdmin;
    //是否单位管理员
    private Boolean isdwAdmin;
    //当前用户身份证号码
    private String useridcard;
    //用户单位
    private String usercompanyid;

    public Boolean getIsdwAdmin() {
        return isdwAdmin;
    }

    public void setIsdwAdmin(Boolean isdwAdmin) {
        this.isdwAdmin = isdwAdmin;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    //当前用户角色
    private List<Role> userrole;

    public List<Role> getUserrole() {
        return userrole;
    }

    public void setUserrole(List<Role> userrole) {
        this.userrole = userrole;
    }

    public String getUseridcard() {
        return useridcard;
    }

    public void setUseridcard(String useridcard) {
        this.useridcard = useridcard;
    }

    public String getUsercompanyid() {
        return usercompanyid;
    }

    public void setUsercompanyid(String usercompanyid) {
        this.usercompanyid = usercompanyid;
    }

    public String getIsalladd() {
        return isalladd;
    }

    public void setIsalladd(String isalladd) {
        this.isalladd = isalladd;
    }

    public String getUids() {
        return uids;
    }

    public void setUids(String uids) {
        this.uids = uids;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getIsdelall() {
        return isdelall;
    }

    public void setIsdelall(String isdelall) {
        this.isdelall = isdelall;
    }
}
