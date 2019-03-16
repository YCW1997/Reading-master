package com.yuan.reading.fragment.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yuan.reading.R;
import com.yuan.reading.adapter.AndroidFragmentAdapter;
import com.yuan.reading.adapter.TodayAdapter;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.TodayBean;
import com.yuan.reading.bean.TodayResponse;
import com.yuan.reading.interfaceclass.AndroidFragmentApi;
import com.yuan.reading.utils.RetrofitUtil;
import com.yuan.reading.utils.RetrofitUtil2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/3/15 0015.
 */

public class TodayFragment extends Fragment {
    View mView;
    private RecyclerView mRecyclerView;
    private AndroidFragmentApi service;
    private Call<TodayResponse<TodayBean.ResultsBean>> callback;
    private TodayAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.android_fragment,container, false);
        }
        mRecyclerView = mView.findViewById (R.id.recyclerview);

        service = RetrofitUtil2.getRetrofit().create(AndroidFragmentApi.class);
        callback=service.getToday();
        callback.enqueue(new Callback<TodayResponse<TodayBean.ResultsBean>>() {
            @Override
            public void onResponse(Call<TodayResponse<TodayBean.ResultsBean>> call, Response<TodayResponse<TodayBean.ResultsBean>> response) {
                if (response.body() != null && null !=response.body().results) {
                    TodayBean.ResultsBean resultsBean=response.body().results;
                    List<TodayBean.ResultsBean.AndroidBean> androidBean=resultsBean.getAndroid();
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    adapter = new TodayAdapter(getActivity(),androidBean);
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.addItemDecoration (new DividerItemDecoration(getActivity (),DividerItemDecoration.VERTICAL));
                }
            }

            @Override
            public void onFailure(Call<TodayResponse<TodayBean.ResultsBean>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }
}