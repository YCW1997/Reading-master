package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public interface AndroidFragmentApi {
    @GET("article/list/{page}/json")
    Call<BaseResponse<AfBean>> getAfBean(@Path("page") int page);

    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Call<BaseResponse<AfBean>> search(@Path("page") int page,@Field("key") String key);
}
