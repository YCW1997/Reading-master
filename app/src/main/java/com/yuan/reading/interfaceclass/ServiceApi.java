package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.UserBean;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2019/2/23 0023.
 */

public interface ServiceApi {

    //登录
    @FormUrlEncoded
    @POST("user/login")
    Call<BaseResponse<UserBean>> login(@FieldMap HashMap<String, Object> map);

    //注册
    @FormUrlEncoded
    @POST("user/register")
    Call<BaseResponse<UserBean>> register(@FieldMap HashMap<String, Object> map);

}
