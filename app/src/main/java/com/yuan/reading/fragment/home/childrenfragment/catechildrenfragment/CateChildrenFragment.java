package com.yuan.reading.fragment.home.childrenfragment.catechildrenfragment;

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
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.yuan.reading.R;
import com.yuan.reading.adapter.AndroidFragmentAdapter;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BannerBean;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.interfaceclass.AndroidFragmentApi;
import com.yuan.reading.interfaceclass.BannerApi;
import com.yuan.reading.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/3/13 0013.
 */

public class CateChildrenFragment extends Fragment{
    View mView;
    private int mPage=0;
    private RecyclerView mRecyclerView;
    private AndroidFragmentApi service;
    private Call<BaseResponse<AfBean>> callback;
    private AndroidFragmentAdapter adapter;

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

        service = RetrofitUtil.getRetrofit().create(AndroidFragmentApi.class);
        Bundle bundle = getArguments();
        int data = bundle.getInt("cid");
        callback=service.getArticleCid(mPage,data);
        callback.enqueue(new Callback<BaseResponse<AfBean>>() {
            @Override
            public void onResponse(Call<BaseResponse<AfBean>> call, Response<BaseResponse<AfBean>> response) {
                if (response.body() != null && null != response.body().data) {
                    AfBean afBean = response.body().data;
                    List<AfBean.ArticleDetailBean> datas=afBean.getDatas();
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    adapter = new AndroidFragmentAdapter(getActivity(),datas);
                    mRecyclerView.setAdapter(adapter);
                    mRecyclerView.addItemDecoration (new DividerItemDecoration(getActivity (),DividerItemDecoration.VERTICAL));

                }
            }

            @Override
            public void onFailure(Call<BaseResponse<AfBean>> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
        return mView;
    }
}