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
public class GroupSearch extends QueryModel {

    //是否包含自建用户组
    private String containOwn;
    //是否包含被分配用户组

    public String getContainOwn() {
        return containOwn;
    }

    public void setContainOwn(String containOwn) {
        this.containOwn = containOwn;
    }

    private String ispulic;

    public String getIspulic() {
        return ispulic;
    }

    public void setIspulic(String ispulic) {
        this.ispulic = ispulic;
    }
    //是否全部添加
    private String isalladd;

    public String getIsalladd() {
        return isalladd;
    }

    public void setIsalladd(String isalladd) {
        this.isalladd = isalladd;
    }
    //身份证集合
    private String uids;

    public String getUids() {
        return uids;
    }

    public void setUids(String uids) {
        this.uids = uids;
    }
    //是否全部添加
    private String isdelall;

    public String getIsdelall() {
        return isdelall;
    }

    public void setIsdelall(String isdelall) {
        this.isdelall = isdelall;
    }
    //角色ID
    private String roleid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
    //单位ID
    private String companyid;

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }
    //是否已分配角色用户组
    private String isadd;

    public String getIsadd() {
        return isadd;
    }

    public void setIsadd(String isadd) {
        this.isadd = isadd;
    }
}
