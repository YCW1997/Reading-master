package com.yuan.reading.fragment.home.childrenfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuan.reading.R;
import com.yuan.reading.adapter.HotFragmentAdapter;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.SearchBean;
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

public class HotFragment extends Fragment{
    View mView;
    private SearchApi service;
    private Call<BaseResponse<List<SearchBean>>> callback;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> datas = new ArrayList<>();
//    private List<Fragment> fragments = new ArrayList<>();
    private HotFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.hot_fragment, null);
        }

        tabLayout = mView.findViewById(R.id.tabLayout);
        viewPager = mView.findViewById(R.id.vp_hot);

        service= RetrofitUtil.getRetrofit().create(SearchApi.class);
        callback=service.getSearch();
        callback.enqueue(new Callback<BaseResponse<List<SearchBean>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<SearchBean>>> call, Response<BaseResponse<List<SearchBean>>> response) {
                if (response.body() != null && null != response.body().data) {
                    List<SearchBean> searchBeans=response.body().data;
                    datas.clear();
                    datas.add(searchBeans.get(0).getName());
                    datas.add(searchBeans.get(1).getName());
                    datas.add(searchBeans.get(2).getName());
                    //循环注入标签
                    for (String tab : datas) {
                        tabLayout.addTab(tabLayout.newTab().setText(tab));
                    }
//                    for (int i = 0; i < 3; i++) {
//                        fragments.add(InterviewFragment.newInstance(i));
//                    }
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
                    adapter = new HotFragmentAdapter(getActivity().getSupportFragmentManager(),datas);
//                    adapter = new HotFragmentAdapter(getActivity().getSupportFragmentManager(),datas,fragments);
                    viewPager.setAdapter(adapter);
                    tabLayout.setupWithViewPager(viewPager);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<SearchBean>>> call, Throwable t) {

            }
        });
        return mView;
    }

}
