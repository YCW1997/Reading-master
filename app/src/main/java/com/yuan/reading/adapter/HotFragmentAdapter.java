package com.yuan.reading.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.fragment.home.childrenfragment.hotchildrenfragment.AnimationFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/3/9 0009.
 */

public class HotFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public HotFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public HotFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
