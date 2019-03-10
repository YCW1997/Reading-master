package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.BannerBean;
import com.yuan.reading.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public interface BannerApi {
    @GET("banner/json")
    Call<BaseResponse<BannerBean>> getBannerBean();
}
