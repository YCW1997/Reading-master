package com.yuan.reading.fragment.accounts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuan.reading.R;

/**
 * Created by Administrator on 2019/2/21 0021.
 */

public class PublicFragment extends Fragment{
    View mView;
    private TextView tv;
    private ImageView iv_title_menu;
    private ViewPager viewPager;
    private AppBarLayout appBarLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.third_fragment, null);
        }
        tv=mView.findViewById(R.id.textView12);
        iv_title_menu = mView.findViewById(R.id.iv_title_menu);
        viewPager = mView.findViewById(R.id.vp_accounts);
        appBarLayout = mView.findViewById(R.id.appbar);

        return mView;
    }
}
