package com.hero.po;

import com.alibaba.fastjson.annotation.JSONField;
import com.hero.systemBase.DatabaseTableName;

import java.util.Date;


/**
 * 实体类-用户
 * @author chenwenwei
 * @time 2018.05.05
 */


@DatabaseTableName("sys_user")
public class User {
    private Integer id;
    private String state;
    @JSONField(name = "account")
    private String account;
    private String password;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    Date addtime;      // 添加时间
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    Date uptime;       // 更新时间


    //getter和setter方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}
