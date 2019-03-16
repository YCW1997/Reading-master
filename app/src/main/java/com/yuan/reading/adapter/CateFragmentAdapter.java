package com.yuan.reading.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yuan.reading.fragment.home.childrenfragment.catechildrenfragment.CateChildrenFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */

public class CateFragmentAdapter extends FragmentPagerAdapter {
    List<Integer> list=new ArrayList<>();
    public CateFragmentAdapter(FragmentManager fm, List<Integer> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        CateChildrenFragment ccf = new CateChildrenFragment();
        bundle.putInt("cid", list.get(position));
        ccf.setArguments(bundle);
        return ccf;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position)+"";
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }
}
