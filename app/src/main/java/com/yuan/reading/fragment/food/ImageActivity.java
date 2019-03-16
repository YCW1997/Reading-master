package com.yuan.reading.fragment.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.adapter.MyImageAdapter;
import com.yuan.reading.bean.TodayBean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/16 0016.
 */

public class ImageActivity extends AppCompatActivity {

    public static final String TAG = ImageActivity.class.getSimpleName();
    private PhotoViewPager mViewPager;
    private int currentPosition;
    private MyImageAdapter adapter;
    private TextView mTvImageCount;
    private List<String> Urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);
        initView();
        initData();
    }

    private void initView() {
        mViewPager = (PhotoViewPager) findViewById(R.id.view_pager_photo);
        mTvImageCount = (TextView) findViewById(R.id.tv_image_count);
    }

    private void initData() {


        Intent intent = getIntent();
        currentPosition = intent.getIntExtra("currentPosition", 0);
        TodayBean.ResultsBean resultsBean = ((TodayBean.ResultsBean) intent.getSerializableExtra("questionlistdataBean"));
        Urls = resultsBean.getAndroid().get(0).getImages();

        adapter = new MyImageAdapter(Urls, this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(currentPosition, false);
        mTvImageCount.setText(currentPosition+1 + "/" + Urls.size());
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPosition = position;
                mTvImageCount.setText(currentPosition + 1 + "/" + Urls.size());
            }
        });
    }
}
