package com.yuan.reading.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yuan.reading.MainActivity;
import com.yuan.reading.R;
import com.yuan.reading.adapter.HomeFragmentPagerAdapter;
import com.yuan.reading.fragment.home.childrenfragment.AndroidFragment;
import com.yuan.reading.fragment.home.childrenfragment.CateFragment;
import com.yuan.reading.fragment.home.childrenfragment.HotFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/2/21 0021.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    View mView;
    private List<Fragment> mFgList = new ArrayList<>();
    private ImageView iv_title_menu;
    private ImageView iv_title_one, iv_title_two, iv_title_three;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.first_fragment, null);
        }

        iv_title_menu = mView.findViewById(R.id.iv_title_menu);
        iv_title_one = mView.findViewById(R.id.iv_title_one);
        iv_title_two = mView.findViewById(R.id.iv_title_two);
        iv_title_three = mView.findViewById(R.id.iv_title_three);
        viewPager = mView.findViewById(R.id.vp_home);
        appBarLayout = mView.findViewById(R.id.appbar);

        Fragment androidFragment = new AndroidFragment();
        Fragment hotFragment = new HotFragment();
        Fragment cateFragment = new CateFragment();

        mFgList.add(androidFragment);
        mFgList.add(hotFragment);
        mFgList.add(cateFragment);

        intClick();
        initData();
        return mView;
    }

    private void intClick() {
        iv_title_menu.setOnClickListener(this);
        iv_title_one.setOnClickListener(this);
        iv_title_two.setOnClickListener(this);
        iv_title_three.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_title_menu:
                ((MainActivity)getActivity()).drawer.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_title_one:
                setCurrent(0);
                break;
            case R.id.iv_title_two:
                setCurrent(1);
                break;
            case R.id.iv_title_three:
                setCurrent(2);
                break;
        }
    }

    public void initData() {
        HomeFragmentPagerAdapter homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getChildFragmentManager(), mFgList);
        viewPager.setAdapter(homeFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCurrent(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setCurrent(1);

    }

    private void setCurrent(int index) {
        boolean isOne = false, isTwo = false, isThree = false;
        switch (index) {
            case 0:
                isOne = true;
                appBarLayout.setElevation(1);
                break;
            case 1:
                isTwo = true;
                appBarLayout.setElevation(0);
                break;
            case 2:
                isThree = true;
                appBarLayout.setElevation(0);
                break;
        }
        viewPager.setCurrentItem(index);
        iv_title_one.setSelected(isOne);
        iv_title_two.setSelected(isTwo);
        iv_title_three.setSelected(isThree);

    }
}
