package com.yuan.reading.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/2/23 0023.
 */

public class RegisterBean {
    private String rusername;
    private String rpassword;
    private String rpassword2;

    public String getRusername() {
        return rusername;
    }

    public void setRusername(String rusername) {
        this.rusername = rusername;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public String getRpassword2() {
        return rpassword2;
    }

    public void setRpassword2(String rpassword2) {
        this.rpassword2 = rpassword2;
    }
}
