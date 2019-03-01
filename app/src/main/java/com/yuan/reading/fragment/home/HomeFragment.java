package com.yuan.reading.fragment.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.fragment.home.childrenfragment.AndroidFragment;
import com.yuan.reading.fragment.home.childrenfragment.CateFragment;
import com.yuan.reading.fragment.home.childrenfragment.HotFragment;

/**
 * Created by Administrator on 2019/2/21 0021.
 */

public class HomeFragment extends Fragment{
    View mView;
    private Toolbar mtoolbar;
    private ActionMenuView mAcitionMenuView;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.img,menu);
    }

    FragmentManager fm=getChildFragmentManager();
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.android:
                Fragment androidFragment = new AndroidFragment();
                FragmentTransaction transaction=fm.beginTransaction();
                if(!androidFragment.isAdded()){
                    transaction.add(R.id.android_fragment, androidFragment).commit();
                }
                return true;
            case R.id.hot:
                Fragment hotFragment = new HotFragment();
                FragmentTransaction transaction2 = fm.beginTransaction();
                if(!hotFragment.isAdded()) {
                    transaction2.add(R.id.hot_fragment, hotFragment).commit();
                }
                return true;
            case R.id.cate:
                Fragment cateFragment = new CateFragment();
                FragmentTransaction transaction3 = fm.beginTransaction();
                if(!cateFragment.isAdded()) {
                    transaction3.add(R.id.cate_fragment, cateFragment).commit();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.first_fragment, null);
        }
        setHasOptionsMenu(true);//需要添加这行代码
        mtoolbar = (Toolbar) mView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mtoolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        mAcitionMenuView = (ActionMenuView) mView.findViewById(R.id.action);
        return mView;
    }
}
