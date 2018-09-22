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
public class EduUserSearch extends QueryModel {

    private String is_lw;

    public String getIs_lw() {
        return is_lw;
    }

    public void setIs_lw(String is_lw) {
        this.is_lw = is_lw;
    }
    private String stu_name;

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
    private String hasrole;

    public String getHasrole() {
        return hasrole;
    }

    public void setHasrole(String hasrole) {
        this.hasrole = hasrole;
    }
    private String idcard;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }
    private String username;
    private String company;
    private String companyid;
}
