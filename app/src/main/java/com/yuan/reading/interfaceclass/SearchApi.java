package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.BannerBean;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.SearchBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2019/3/11 0011.
 */

public interface SearchApi {
    @GET("hotkey/json")
    Call<BaseResponse<List<SearchBean>>> getSearch();
}
