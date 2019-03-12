package com.yuan.reading.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yuan.reading.fragment.home.childrenfragment.hotchildrenfragment.InterviewFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/9 0009.
 */

public class HotFragmentAdapter extends FragmentPagerAdapter {
    List<String> list=new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    public HotFragmentAdapter(FragmentManager fm, List<String> list, List<Fragment> fragments) {
        super(fm);
        this.list = list;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        InterviewFragment fg = new InterviewFragment();
        bundle.putString("name", list.get(position));
        fg.setArguments(bundle);
        return fg;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }
}