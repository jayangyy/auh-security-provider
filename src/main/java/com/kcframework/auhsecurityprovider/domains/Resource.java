/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kcframework.auhsecurityprovider.domains;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jayang
 */
@Table(name = "demands_resources")
public class Resource {

    //是否传参数
    private Boolean is_params;
    //是否编码
    private Boolean is_encode;
    //编码类型
    private String encode_type;
    //是否外链
    private Boolean is_wl;

    public Boolean getIs_wl() {
        return is_wl;
    }

    public void setIs_wl(Boolean is_wl) {
        this.is_wl = is_wl;
    }

    private Integer res_pid;

    public Integer getRes_pid() {
        return res_pid;
    }

    public void setRes_pid(Integer res_pid) {
        this.res_pid = res_pid;
    }
    @Id
    private Integer res_id;
    private String res_name;

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_url() {
        return res_url;
    }

    public void setRes_url(String res_url) {
        this.res_url = res_url;
    }

    public boolean isRes_enable() {
        return res_enable;
    }

    public void setRes_enable(boolean res_enable) {
        this.res_enable = res_enable;
    }
    private String res_url;
    private boolean res_enable;

    public Boolean getIs_params() {
        return is_params;
    }

    public void setIs_params(Boolean is_params) {
        this.is_params = is_params;
    }

    public Boolean getIs_encode() {
        return is_encode;
    }

    public void setIs_encode(Boolean is_encode) {
        this.is_encode = is_encode;
    }

    public String getEncode_type() {
        return encode_type;
    }

    public void setEncode_type(String encode_type) {
        this.encode_type = encode_type;
    }

}
