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
    public static String base_url="http://www.wanandroid.com/";

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
        callback = service.login(et.getText().toString(), et2.getText().toString());
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    callback.enqueue(new Callback<LoginBean>() {
                        @Override
                        public void onResponse(retrofit2.Call<LoginBean> call, Response<LoginBean> response) {
                            Log.i("isSuccess", "true");
                                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }

                        @Override
                        public void onFailure(Call<LoginBean> call, Throwable t) {
                            Toast.makeText(getActivity().getApplicationContext(), "请求失败", Toast.LENGTH_SHORT).show();
                        }
                    });
            }
        });
        return mView;
    }
}
