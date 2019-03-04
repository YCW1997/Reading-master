package com.yuan.reading;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.yuan.reading.adapter.ViewPagerFragmentAdapter;
import com.yuan.reading.fragment.food.FoodFragment;
import com.yuan.reading.fragment.home.HomeFragment;
import com.yuan.reading.fragment.mine.MyFragment;
import com.yuan.reading.fragment.accounts.PublicFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = "MainActivity.TAG";
    public LinearLayout firstLinearLayout;
    public LinearLayout secondLinearLayout;
    public LinearLayout threeLinearLayout;
    public LinearLayout fourLinearLayout;
    ViewPager mViewPager;
    ViewPagerFragmentAdapter mViewPagerFragmentAdapter;
    FragmentManager mFragmentManager;

    String[] titleName = new String[]{"首页", "干货", "公众号", "我的"};
    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    public DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main2);

        initFragmetList();
        initView();
        initViewPager();
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//    @Override
//    public void onBackPressed() {//为什么要写这个方法
////        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.mycollection) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.todo) {

        } else if (id == R.id.note) {

        } else if (id == R.id.pwd) {

        } else if (id == R.id.theme) {

        } else if (id == R.id.setting) {

        } else if (id == R.id.exit) {

        }
        drawer.closeDrawer(GravityCompat.START);
//
//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);//为什么又一次的finviewbyfid
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void initViewPager() {
        mViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(mFragmentManager, mFragmentList);
        mViewPager.addOnPageChangeListener(new ViewPagetOnPagerChangedLisenter());
        mViewPager.setAdapter(mViewPagerFragmentAdapter);
        mViewPager.setCurrentItem(0);
        updateBottomLinearLayoutSelect(true, false, false, false);
    }

    public void initFragmetList() {
        Fragment first = new HomeFragment();
        Fragment second = new FoodFragment();
        Fragment third = new PublicFragment();
        Fragment four = new MyFragment();
        mFragmentList.add(first);
        mFragmentList.add(second);
        mFragmentList.add(third);
        mFragmentList.add(four);
    }

    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.ViewPagerLayout);
        firstLinearLayout = (LinearLayout) findViewById(R.id.firstLinearLayout);
        firstLinearLayout.setOnClickListener(this);
        secondLinearLayout = (LinearLayout) findViewById(R.id.secondLinearLayout);
        secondLinearLayout.setOnClickListener(this);
        threeLinearLayout = (LinearLayout) findViewById(R.id.threeLinearLayout);
        threeLinearLayout.setOnClickListener(this);
        fourLinearLayout = (LinearLayout) findViewById(R.id.fourLinearLayout);
        threeLinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstLinearLayout:
                mViewPager.setCurrentItem(0);
                updateBottomLinearLayoutSelect(true, false, false, false);
                break;
            case R.id.secondLinearLayout:
                mViewPager.setCurrentItem(1);
                updateBottomLinearLayoutSelect(false, true, false, false);
                break;
            case R.id.threeLinearLayout:
                mViewPager.setCurrentItem(2);
                updateBottomLinearLayoutSelect(false, false, true, false);
                break;
            case R.id.fourLinearLayout:
                mViewPager.setCurrentItem(3);
                updateBottomLinearLayoutSelect(false, false, false, true);
                break;
            default:
                break;
        }
    }

    private void updateBottomLinearLayoutSelect(boolean f, boolean s, boolean t, boolean o) {
        firstLinearLayout.setSelected(f);
        secondLinearLayout.setSelected(s);
        threeLinearLayout.setSelected(t);
        fourLinearLayout.setSelected(o);

    }

    class ViewPagetOnPagerChangedLisenter implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            Log.d(TAG,"onPageScrooled");
        }

        @Override
        public void onPageSelected(int position) {
            Log.d(TAG, "onPageSelected");
            boolean[] state = new boolean[titleName.length];
            state[position] = true;
            updateBottomLinearLayoutSelect(state[0], state[1], state[2], state[3]);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Log.d(TAG, "onPageScrollStateChanged");
        }
    }


}