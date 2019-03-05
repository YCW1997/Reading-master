package com.yuan.reading.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class AndroidFragmentAdapter extends RecyclerView.Adapter<AndroidFragmentAdapter.MyViewHolder> {
    Context context;
    private List<AfBean> list;
    private LayoutInflater mLayoutInflater;

    public AndroidFragmentAdapter(Context context, List<AfBean> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(mLayoutInflater.inflate(R.layout.android_fragment_list, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AfBean item = list.get (position);
        holder.tv.setText(item.getCurPage());
        holder.tv2.setText(item.getOffset());
        holder.tv3.setText(item.getDatas().toString());
        holder.tv4.setText(item.getPageCount());
        holder.tv5.setText(item.getTotal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.textView)
         TextView tv;
         @BindView(R.id.textView2)
         TextView tv2;
         @BindView(R.id.textView3)
         TextView tv3;
         @BindView(R.id.textView4)
         TextView tv4;
         @BindView(R.id.textView5)
         TextView tv5;
         public MyViewHolder(View itemView) {
             super(itemView);
             ButterKnife.bind(this,itemView);
         }
     }
}