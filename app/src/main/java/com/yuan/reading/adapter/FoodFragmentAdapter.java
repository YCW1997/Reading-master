package com.yuan.reading.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/3/15 0015.
 */

public class FoodFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public FoodFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public FoodFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}