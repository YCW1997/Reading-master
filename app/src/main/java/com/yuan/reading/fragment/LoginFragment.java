package com.yuan.reading.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yuan.reading.MainActivity;
import com.yuan.reading.R;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.UserBean;
import com.yuan.reading.interfaceclass.ServiceApi;
import com.yuan.reading.utils.RetrofitUtil;
import com.yuan.reading.utils.SPUtils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/2/22 0022.
 */

public class LoginFragment extends Fragment {
    View mView;
    private EditText et, et2;
    private Button loginbtn;
    private ServiceApi service;
    private Call<BaseResponse<UserBean>> callback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.login_fragment, null);
        }
        loginbtn = mView.findViewById(R.id.loginbtn);
        et = mView.findViewById(R.id.editText);
        et2 = mView.findViewById(R.id.editText2);


        service = RetrofitUtil.getRetrofit().create(ServiceApi.class);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("username", et.getText().toString());
                map.put("password", et2.getText().toString());

                if (et.getText().toString().length() != 0 && et2.getText().toString().length() != 0) {
                    if (isEmail(et.getText().toString())) {
                        callback = service.login(map);
                        callback.enqueue(new Callback<BaseResponse<UserBean>>() {
                            @Override
                            public void onResponse(retrofit2.Call<BaseResponse<UserBean>> call, Response<BaseResponse<UserBean>> response) {

                                if (response.body() != null && null != response.body().data) {
                                    UserBean userBean = response.body().data;
//                                    //把userBean这个对象保存到SharedPreferences中
//                                    SharedPreferences sharedPreferences=getActivity().getSharedPreferences("loginUser", Context.MODE_PRIVATE);
//                                    SharedPreferences.Editor editor=sharedPreferences.edit();
//                                    editor.putString("user",new Gson().toJson(userBean,UserBean.class));
//                                    editor.putString(userBean.username,userBean.password);//不能这样写 保存的是一个对象
//                                    editor.commit();

                                    SPUtils.put("user",new Gson().toJson(userBean));
                                    Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onFailure(Call<BaseResponse<UserBean>> call, Throwable t) {
                                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(getActivity(), "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
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
