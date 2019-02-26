package com.yuan.reading.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuan.reading.R;
import com.yuan.reading.bean.RegisterBean;
import com.yuan.reading.interfaceclass.ServiceApi;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/2/22 0022.
 */

public class RegisterFragment extends Fragment {
    View mView;
    private EditText et3,et4,et5;
    private Button registerbtn;
    private Call<RegisterBean> callback2;
    private RegisterBean registerBean;
    private ServiceApi service;
    public static String base_url="http://www.wanandroid.com/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.register_fragment, null);
        }
        registerbtn=mView.findViewById(R.id.registerbtn);
        et3=mView.findViewById(R.id.editText3);
        et4=mView.findViewById(R.id.editText4);
        et5=mView.findViewById(R.id.editText5);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();//增加返回值为实体类的支持
        service=retrofit.create(ServiceApi.class);
        callback2 = service.register(et3.getText().toString(), et4.getText().toString(), et5.getText().toString());
//        service=new RetrofitLogin().getService();
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback2.enqueue(new Callback<RegisterBean>() {
                    @Override
                    public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                        Log.i("isSuccess", "true");
                        response.body();
                            Toast.makeText(getActivity().getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegisterBean> call, Throwable t) {
                        Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                    }
                });
        }
        });
        return mView;
    }

}
