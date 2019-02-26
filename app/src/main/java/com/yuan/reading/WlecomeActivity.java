package com.yuan.reading;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class WlecomeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏以及状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wlecome);

        handler.sendEmptyMessageDelayed(0,3000);
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            getHome();
            super.handleMessage(msg);
        }
    };

    public void getHome(){
        Intent intent=new Intent(WlecomeActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
