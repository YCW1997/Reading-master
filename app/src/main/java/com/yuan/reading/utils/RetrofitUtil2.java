package com.yuan.reading.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/3/15 0015.
 */

public class RetrofitUtil2 {
    private static volatile RetrofitUtil2 retrofitUtil = null;
    private Retrofit retrofit = null;

    private RetrofitUtil2() {
        retrofit = new Retrofit.Builder()
                // 设置BaseURL
                .baseUrl("https://gank.io/api/")
                // 增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static RetrofitUtil2 getInstance() {
        if (retrofitUtil == null) {
            synchronized (RetrofitUtil2.class) {
                if (retrofitUtil == null) {
                    retrofitUtil = new RetrofitUtil2();
                }
            }
        }
        return retrofitUtil;
    }

    public static Retrofit getRetrofit() {
        return getInstance().retrofit;
    }
}
