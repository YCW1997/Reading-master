package com.yuan.reading.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static volatile RetrofitUtil retrofitUtil = null;
    private Retrofit retrofit = null;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                // 设置BaseURL
                .baseUrl("http://www.wanandroid.com/")
                // 增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static RetrofitUtil getInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil();
                }
            }
        }
        return retrofitUtil;
    }

    public static Retrofit getRetrofit() {
        return getInstance().retrofit;
    }
}