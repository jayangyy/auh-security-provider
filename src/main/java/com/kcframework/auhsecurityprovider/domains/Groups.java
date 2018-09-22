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
public class Groups {

    //添加人身份证号码
    private String group_adduser;
    //添加人单位
    private String group_addunit;
    //添加人单位ID
    private String group_addunitid;
    //添加人姓名
    private String group_addusername;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String group_name;

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_adduser() {
        return group_adduser;
    }

    public void setGroup_adduser(String group_adduser) {
        this.group_adduser = group_adduser;
    }

    public String getGroup_addunit() {
        return group_addunit;
    }

    public void setGroup_addunit(String group_addunit) {
        this.group_addunit = group_addunit;
    }

    public String getGroup_addunitid() {
        return group_addunitid;
    }

    public void setGroup_addunitid(String group_addunitid) {
        this.group_addunitid = group_addunitid;
    }

    public String getGroup_addusername() {
        return group_addusername;
    }

    public void setGroup_addusername(String group_addusername) {
        this.group_addusername = group_addusername;
    }

}
