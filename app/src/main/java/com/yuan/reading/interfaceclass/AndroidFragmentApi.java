package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.TodayBean;
import com.yuan.reading.bean.TodayResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public interface AndroidFragmentApi {
    @GET("article/list/{page}/json")
    Call<BaseResponse<AfBean>> getAfBean(@Path("page") int page);

    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Call<BaseResponse<AfBean>> search(@Path("page") int page,@Field("k") String key);

    @GET("article/list/{page}/json")
    Call<BaseResponse<AfBean>> getArticleCid(@Path("page") int page, @Query("cid") int cid);

    @GET("today")
    Call<TodayResponse<TodayBean.ResultsBean>> getToday();
}
