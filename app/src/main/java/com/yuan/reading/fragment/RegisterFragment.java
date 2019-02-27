package com.yuan.reading.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuan.reading.MainActivity;
import com.yuan.reading.R;
import com.yuan.reading.bean.BaseResponse;
import com.yuan.reading.bean.UserBean;
import com.yuan.reading.interfaceclass.ServiceApi;
import com.yuan.reading.utils.RetrofitUtil;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2019/2/22 0022.
 */

public class RegisterFragment extends Fragment {
    View mView;
    private EditText et3,et4,et5;
    private Button registerbtn;
    private Call<BaseResponse<UserBean>> callback2;
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

        service = RetrofitUtil.getRetrofit().create(ServiceApi.class);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("email", et3.getText().toString());
                        map.put("password", et4.getText().toString());

                        if (et3.getText().toString().length() != 0 && et4.getText().toString().length() != 0 && et5.getText().toString().length() != 0) {
                            if (et4.getText().toString().equals(et5.getText().toString())) {
                                if (isEmail(et3.getText().toString())) {
                                    callback2 = service.register(map);
                                    callback2.enqueue(new Callback<BaseResponse<UserBean>>() {
                                        @Override
                                        public void onResponse(retrofit2.Call<BaseResponse<UserBean>> call, Response<BaseResponse<UserBean>> response) {
//                                            if (response.body() != null && null != response.body().data) {
//                                                UserBean userBean = response.body().data;
                                                Toast.makeText(getActivity().getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                                                Toast.makeText(getActivity().getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                                startActivity(intent);
                                            }
//                                        }

                                        @Override
                                        public void onFailure(Call<BaseResponse<UserBean>> call, Throwable t) {
                                            Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getActivity().getApplicationContext(), "请输入正确的邮箱", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getActivity().getApplicationContext(), "请保持密码一致", Toast.LENGTH_SHORT).show();
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
