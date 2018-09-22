/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.domains;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jayan
 */
//@ApiModel("BaseUser")
@Table(name = "demands_users")
public class DemandsUsers implements Serializable {

    public DemandsUsers() {
//        this.uinfo = new DemandsUserinfos();
//        this.account = new DemandsUserAccount();
    }
    @Id
    @Column(name = "user_code")
    private int user_code;
    //用户名
    @Column(name = "user_name")
    private String user_name;
//用户密码
    @Column(name = "user_password")
    private String user_password;
//    private DemandsUserinfos uinfo;
//    //账户信息
//    private DemandsUserAccount account;
    //投标数目
    private int bid_num;
    //订单数目
    private int order_num;

    public int getBid_num() {
        return bid_num;
    }

    public void setBid_num(int bid_num) {
        this.bid_num = bid_num;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

//    public DemandsUserAccount getAccount() {
//        return account;
//    }
//
//    public void setAccount(DemandsUserAccount account) {
//        this.account = account;
//    }
//
//    public DemandsUserinfos getUinfo() {
//        return uinfo;
//    }
//
//    public void setUinfo(DemandsUserinfos uinfo) {
//        this.uinfo = uinfo;
//    }

    public int getUser_code() {
        return user_code;
    }

    public void setUser_code(int user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
