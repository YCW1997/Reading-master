package com.yuan.reading.fragment.home.childrenfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.adapter.HotFragmentAdapter;
import com.yuan.reading.fragment.home.childrenfragment.hotchildrenfragment.AnimationFragment;
import com.yuan.reading.fragment.home.childrenfragment.hotchildrenfragment.InterviewFragment;
import com.yuan.reading.fragment.home.childrenfragment.hotchildrenfragment.Studio3Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2019/3/1 0001.
 */

public class HotFragment extends Fragment implements ViewPager.OnPageChangeListener,View.OnClickListener{
    View mView;
    private List<Fragment> list=new ArrayList<Fragment>();
    private ViewPager viewPager;
    private TextView tv,tv2,tv3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.hot_fragment, null);
        }
        initView();
        return mView;
    }

    private void initView(){
        viewPager=(ViewPager)mView.findViewById(R.id.vp_hot);
        tv=(TextView)mView.findViewById(R.id.textView);
        tv2=(TextView)mView.findViewById(R.id.textView2);
        tv3=(TextView)mView.findViewById(R.id.textView3);
        tv.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

        list.add(new InterviewFragment());
        list.add(new Studio3Fragment());
        list.add(new AnimationFragment());

        viewPager.setAdapter(new HotFragmentAdapter(getFragmentManager(),list));
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        initBtnListener();
        switch (position){
            case 0:
                tv.setBackgroundColor(Color.parseColor("#ff0000"));
                break;
            case 1:
                tv2.setBackgroundColor(Color.parseColor("#ff0000"));
                break;
            case 2:
                tv3.setBackgroundColor(Color.parseColor("#ff0000"));
                break;
                default:
                    break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView:
                tv.setBackgroundColor(Color.parseColor("#ff0000"));
                viewPager.setCurrentItem(0);
                break;
            case R.id.textView2:
                tv2.setBackgroundColor(Color.parseColor("#ff0000"));
                viewPager.setCurrentItem(1);
                break;
            case R.id.textView3:
                tv3.setBackgroundColor(Color.parseColor("#ff0000"));
                viewPager.setCurrentItem(2);
                break;
                default:
                break;
        }
    }

    private void initBtnListener(){
        tv.setBackgroundColor(Color.parseColor("#ffffff"));
        tv2.setBackgroundColor(Color.parseColor("#ffffff"));
        tv3.setBackgroundColor(Color.parseColor("#ffffff"));
    }
}
