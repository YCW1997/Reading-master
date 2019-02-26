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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.register_fragment, null);
        }
        registerbtn = mView.findViewById(R.id.registerbtn);
        et3 = mView.findViewById(R.id.editText3);
        et4 = mView.findViewById(R.id.editText4);
        et5 = mView.findViewById(R.id.editText5);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();//增加返回值为实体类的支持
        service = retrofit.create(ServiceApi.class);
                registerbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (et3.getText().toString().length() != 0 && et4.getText().toString().length() != 0 && et5.getText().toString().length() != 0) {
                            if (isEmail(et3.getText().toString())==true) {
                                callback2 = service.register(et3.getText().toString(), et4.getText().toString(), et5.getText().toString());
                                callback2.enqueue(new Callback<RegisterBean>() {
                                    @Override
                                    public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
//                                        System.out.println(call.request().body());
//                                        System.out.println(response.body());
                                        if (call.request().body().toString().equals(callback2.toString())) {
                                            Toast.makeText(getActivity().getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(getActivity().getApplicationContext(), "注册失败", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<RegisterBean> call, Throwable t) {
                                        Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                Toast.makeText(getActivity().getApplicationContext(), "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                                    Toast.makeText(getActivity().getApplicationContext(), "请输入内容", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return mView;
    }

    public static boolean isEmail(String strEmail) {
        String strPattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }
}
