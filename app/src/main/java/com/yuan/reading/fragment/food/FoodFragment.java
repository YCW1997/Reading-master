package com.yuan.reading.fragment.food;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.adapter.CateFragmentAdapter;
import com.yuan.reading.adapter.FoodFragmentAdapter;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.CateBean;
import com.yuan.reading.interfaceclass.ProjectApi;
import com.yuan.reading.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/2/21 0021.
 */

public class FoodFragment extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{

    private List<Fragment> list;
    private View view;
    private ViewPager viewPager;
    private Button button01,button02,button03,button04;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.second_fragment,container,false);
        initView();
        return view;
    }

    private void initView() {
        viewPager=(ViewPager)view.findViewById(R.id.vp_food);

        list=new ArrayList<>();
        button01=(Button)view.findViewById(R.id.frag01);
        button02=(Button)view.findViewById(R.id.frag02);

        button01.setOnClickListener(this);
        button02.setOnClickListener(this);

        //这些界面要也要一个一个先去实现
        list.add(new TodayFragment());
        list.add(new Food_AndroidFragment());

        viewPager.setAdapter(new FoodFragmentAdapter(getFragmentManager(),list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        initBtnListener();
        switch (i){
            case 0:
                button01.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
            case 1:
                button02.setBackgroundColor(Color.parseColor("#ff735c"));
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onClick(View v) {
        initBtnListener();
        switch (v.getId()){
            case R.id.frag01:
                button01.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(0);
                break;
            case R.id.frag02:
                button02.setBackgroundColor(Color.parseColor("#ff735c"));
                viewPager.setCurrentItem(1);
                break;
        }
    }

    private void initBtnListener(){

        button01.setBackgroundColor(Color.parseColor("#ffffff"));
        button02.setBackgroundColor(Color.parseColor("#ffffff"));
    }
}