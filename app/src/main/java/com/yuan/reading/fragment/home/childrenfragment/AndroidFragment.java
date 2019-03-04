package com.yuan.reading.fragment.home.childrenfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.yuan.reading.R;
import com.yuan.reading.adapter.AndroidFragmentAdapter;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.UserBean;
import com.yuan.reading.interfaceclass.AndroidFragmentApi;
import com.yuan.reading.interfaceclass.ServiceApi;
import com.yuan.reading.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class AndroidFragment extends Fragment {
    View mView;
    private ListView listView;
    private List<BaseResponse<AfBean>> mylist = new ArrayList<BaseResponse<AfBean>>();
    private AndroidFragmentApi service;
    private Call<BaseResponse<AfBean>> callback;
    private AndroidFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.android_fragment, null);
        }
        listView = (ListView)mView.findViewById(R.id.af_listview);


        service = RetrofitUtil.getRetrofit().create(AndroidFragmentApi.class);
        callback=service.getAfBean(1);
        callback.enqueue(new Callback<BaseResponse<AfBean>>() {
            @Override
            public void onResponse(Call<BaseResponse<AfBean>> call, Response<BaseResponse<AfBean>> response) {
                AfBean afBean=response.body().data;
                System.out.println(Thread.currentThread().getName());
                System.out.println(mylist.toString());
                mylist.set(0,response.body());
                listView.setAdapter(new AndroidFragmentAdapter(getActivity(),mylist));
                Toast.makeText(getActivity().getApplicationContext(), "请求成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<BaseResponse<AfBean>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }
        });


        return mView;
    }
}