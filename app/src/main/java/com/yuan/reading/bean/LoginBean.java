package com.yuan.reading.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/2/23 0023.
 */

public class LoginBean {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
