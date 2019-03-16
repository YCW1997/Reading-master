package com.yuan.reading.fragment.home.childrenfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuan.reading.R;
import com.yuan.reading.adapter.CateFragmentAdapter;
import com.yuan.reading.adapter.HotFragmentAdapter;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.CateBean;
import com.yuan.reading.bean.SearchBean;
import com.yuan.reading.fragment.home.childrenfragment.catechildrenfragment.CateChildrenFragment;
import com.yuan.reading.interfaceclass.ProjectApi;
import com.yuan.reading.interfaceclass.SearchApi;
import com.yuan.reading.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class CateFragment extends Fragment {
    View mView;
    private ProjectApi service;
    private Call<BaseResponse<List<CateBean>>> callback;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Integer> datas = new ArrayList<>();
    private CateFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.cate_fragment, null);
        }
        tabLayout = mView.findViewById(R.id.tabLayout);
        viewPager = mView.findViewById(R.id.vp_hot);

        service= RetrofitUtil.getRetrofit().create(ProjectApi.class);
        callback=service.getCate();
        callback.enqueue(new Callback<BaseResponse<List<CateBean>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<CateBean>>> call, Response<BaseResponse<List<CateBean>>> response) {
                if (response.body() != null && null != response.body().data) {
                    List<CateBean> searchBeans=response.body().data;
                    datas.clear();
                    for (int i = 0; i < searchBeans.size(); i++) {
                        datas.add(searchBeans.get(i).getId());
                    }
                    //循环注入标签
                    for (Integer tab : datas) {
                        tabLayout.addTab(tabLayout.newTab().setText(tab+""));
                    }
                    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });
                    adapter = new CateFragmentAdapter(getActivity().getSupportFragmentManager(),datas);
                    viewPager.setAdapter(adapter);
                    tabLayout.setupWithViewPager(viewPager);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<CateBean>>> call, Throwable t) {

            }
        });
        return mView;
    }
}