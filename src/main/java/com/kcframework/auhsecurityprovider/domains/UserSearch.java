/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.domains;
/**
 *
 * @author Jayang
 */
public class UserSearch extends QueryModel {

    //用户组ID
    private String groupid;
    //是否分配用户组
    private String isgroupshare;

    public String getIsgroupshare() {
        return isgroupshare;
    }

    public void setIsgroupshare(String isgroupshare) {
        this.isgroupshare = isgroupshare;
    }
    //角色ID
    private String roleid;
    //部门ID

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    private String depid;

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }
    //是否已分配
    private String isshare;

    //单位ID
    private String companyid;

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getIsshare() {
        return isshare;
    }

    public void setIsshare(String isshare) {
        this.isshare = isshare;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
}
