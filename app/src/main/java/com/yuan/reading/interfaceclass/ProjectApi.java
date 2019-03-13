package com.yuan.reading.interfaceclass;

import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.CateBean;
import com.yuan.reading.bean.SearchBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2019/3/13 0013.
 */

public interface ProjectApi {
    @GET("project/tree/json")
    Call<BaseResponse<List<CateBean>>> getCate();
}
