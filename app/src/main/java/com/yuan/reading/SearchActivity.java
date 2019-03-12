package com.yuan.reading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.SearchBean;
import com.yuan.reading.interfaceclass.SearchApi;
import com.yuan.reading.utils.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    private SearchApi service;
    private Call<BaseResponse<List<SearchBean>>> callback;
    private EditText et;
    private TextView tv,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et=(EditText)findViewById(R.id.editText6) ;
        tv=(TextView)findViewById(R.id.textView6) ;
        tv2=(TextView)findViewById(R.id.textView8) ;
        tv3=(TextView)findViewById(R.id.textView10) ;

        service= RetrofitUtil.getRetrofit().create(SearchApi.class);
        callback=service.getSearch();
        callback.enqueue(new Callback<BaseResponse<List<SearchBean>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<SearchBean>>> call, Response<BaseResponse<List<SearchBean>>> response) {
                if (response.body() != null && null != response.body().data) {
                    List<SearchBean> searchBeans=response.body().data;
                    tv.setText(searchBeans.get(0).getName());
                    tv2.setText(searchBeans.get(1).getName());
                    tv3.setText(searchBeans.get(2).getName());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<SearchBean>>> call, Throwable t) {
            }
        });
    }
}
