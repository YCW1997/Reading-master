package com.yuan.reading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuan.reading.R;

/**
 * Created by Administrator on 2019/2/21 0021.
 */

public class HomeFragment extends Fragment {
    View mView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.first_fragment, null);
        }
        ((TextView) mView.findViewById(R.id.tv1)).setText("首页");
        return mView;
    }
}
