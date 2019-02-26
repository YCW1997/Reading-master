package com.yuan.reading.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuan.reading.MainActivity;
import com.yuan.reading.R;
import com.yuan.reading.bean.LoginBean;
import com.yuan.reading.interfaceclass.ServiceApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/2/22 0022.
 */

public class LoginFragment extends Fragment {
    View mView;
    private EditText et,et2;
    private Button loginbtn;
    private ServiceApi service;
    private LoginBean loginBean;
    private Call<LoginBean> callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.login_fragment, null);
        }
        loginbtn=mView.findViewById(R.id.loginbtn);
        et=mView.findViewById(R.id.editText);
        et2=mView.findViewById(R.id.editText2);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(ServiceApi.class);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et.getText().toString().length() != 0 && et2.getText().toString().length() != 0) {
                    if (isEmail(et.getText().toString()) == true) {
                        callback = service.login(et.getText().toString(), et2.getText().toString());
                        callback.enqueue(new Callback<LoginBean>() {
                            @Override
                            public void onResponse(retrofit2.Call<LoginBean> call, Response<LoginBean> response) {
//                                System.out.println(call.request().body());
//                                System.out.println(response.body());
                                if (response.body().toString().equals(callback.toString())) {
                                    Toast.makeText(getActivity().getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(getActivity().getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginBean> call, Throwable t) {
                                Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        Toast.makeText(getActivity().getApplicationContext(), "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
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
