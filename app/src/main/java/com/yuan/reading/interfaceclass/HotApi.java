package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.SearchBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019/3/11 0011.
 */

public interface HotApi {
    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Call<BaseResponse<List<SearchBean>>> search(@Path("page") int page,@Field("k") String key);
}
