/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.domains;

import javax.persistence.Table;

/**
 *
 * @author Jayang
 */
@Table(name="demands_user_roles")
public class UserRole {
    private int id;
    private String useranme;

    public String getUseranme() {
        return useranme;
    }

    public void setUseranme(String useranme) {
        this.useranme = useranme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    private  int roleid;
}
