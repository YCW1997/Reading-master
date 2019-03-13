package com.yuan.reading.fragment.home.childrenfragment.hotchildrenfragment;

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
 * Created by Administrator on 2019/3/9 0009.
 */

public class InterviewFragment extends Fragment {
    View mView;

//    public static final String ARGS_PAGE = "args_page";
    private int mPage=0;

    private RecyclerView mRecyclerView;
    private XBanner banner;
    private AndroidFragmentApi service;
    private BannerApi service2;
    private Call<BaseResponse<AfBean>> callback;
    private Call<BaseResponse<List<BannerBean>>> callback2;
    private AndroidFragmentAdapter adapter;

//    public static InterviewFragment newInstance(int page) {
//        Bundle args = new Bundle();
//        args.putInt(ARGS_PAGE, page);
//        InterviewFragment fragment = new InterviewFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(ARGS_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.interview_fragment,container, false);
        }
        mRecyclerView = mView.findViewById (R.id.rv_interview);

        service = RetrofitUtil.getRetrofit().create(AndroidFragmentApi.class);
//        int page=mPage;
        Bundle bundle = getArguments();
        String data = bundle.getString("name");
        callback=service.search(mPage,data);
//        callback=service.getAfBean(1);
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

//        banner = (XBanner) mView.findViewById(R.id.banner);
//        service2 = RetrofitUtil.getRetrofit().create(BannerApi.class);
//        callback2=service2.getBannerBean();
//        callback2.enqueue(new Callback<BaseResponse<List<BannerBean>>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<List<BannerBean>>> call, final Response<BaseResponse<List<BannerBean>>> response) {
//                if (response.body() != null && null != response.body().data) {
//                    List<BannerBean> bannerBean=response.body().data;
//
//                    final List<String> img = new ArrayList<String>();
//                    final List<String> title = new ArrayList<String>();
//                    for (int i = 0; i <bannerBean.size() ; i++) {
//                        img.add(bannerBean.get(i).getimagePath());
//                        title.add(bannerBean.get(i).getTitle());
//                    }
//
//                    banner.setData(img,title);
//                    banner.setmAdapter(new XBanner.XBannerAdapter() {
//                        @Override
//                        public void loadBanner(XBanner banner, Object model, View view, int position) {
//                            Glide.with(getActivity()).load(img.get(position)).into((ImageView) view);
//                        }
//                    });
//                    banner.setPageTransformer(Transformer.Default);//横向移动
////                    banner.setPageTransformer(Transformer.Alpha); //渐变，效果不明显
////                    banner.setPageTransformer(Transformer.Rotate);  //单页旋转
////                    banner.setPageTransformer(Transformer.Cube);    //立体旋转
////                    banner.setPageTransformer(Transformer.Flip);  // 反转效果
////                    banner.setPageTransformer(Transformer.Accordion); //三角换页
////                    banner.setPageTransformer(Transformer.ZoomFade); // 缩小本页，同时放大另一页
////                    banner.setPageTransformer(Transformer.ZoomCenter); //本页缩小一点，另一页就放大
////                    banner.setPageTransformer(Transformer.ZoomStack); // 本页和下页同事缩小和放大
////                    banner.setPageTransformer(Transformer.Stack);  //本页和下页同时左移
////                    banner.setPageTransformer(Transformer.Depth);  //本页左移，下页从后面出来
////                    banner.setPageTransformer(Transformer.Zoom);  //本页刚左移，下页就在后面
//                    // 设置XBanner页面切换的时间，即动画时长
//                    banner.setPageChangeDuration(1000);
//
//                    banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(XBanner banner, int position) {
//                            Toast.makeText(getActivity().getApplicationContext(), "点击了第"+position+"图片", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<List<BannerBean>>> call, Throwable t) {
//                Toast.makeText(getActivity().getApplicationContext(), "失败", Toast.LENGTH_SHORT).show();
//            }
//        });

        return mView;
    }
}