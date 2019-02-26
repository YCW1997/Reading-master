package com.yuan.reading.interfaceclass;

import android.database.Observable;

import com.yuan.reading.bean.LoginBean;
import com.yuan.reading.bean.RegisterBean;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/2/23 0023.
 */

public interface ServiceApi {

    public static String base_url="http://www.wanandroid.com/";


    //登录
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginBean> login(@Field("username") String username,
                          @Field("password") String password);
    //注册
    @FormUrlEncoded
    @POST("user/register")
    Call<RegisterBean> register(@Field("rusername") String rusername,
                                @Field("rpassword") String rpassword,
                                @Field("rpassword2") String rpassword2);

}
