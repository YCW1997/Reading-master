package com.yuan.reading;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yuan.reading.adapter.ViewPagerFragmentAdapter;
import com.yuan.reading.fragment.LoginFragment;
import com.yuan.reading.fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    ViewPager vp;
    FragmentManager mFragmentManager;
    ViewPagerFragmentAdapter mViewPagerFragmentAdapter;
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_login);

        setVp();
        vp = (ViewPager) findViewById(R.id.viewPager);
        mViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(mFragmentManager,list);
        vp.setAdapter(mViewPagerFragmentAdapter);
    }

    private void setVp() {
            list = new ArrayList<>();
            Fragment login = new LoginFragment();
            Fragment register=new RegisterFragment();
            Bundle bundle = new Bundle();
            login.setArguments(bundle);
            register.setArguments(bundle);
            list.add(login);
            list.add(register);
        }
}