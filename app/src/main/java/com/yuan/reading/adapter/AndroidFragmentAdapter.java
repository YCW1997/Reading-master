package com.yuan.reading.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.yuan.reading.R;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class AndroidFragmentAdapter extends RecyclerView.Adapter<AndroidFragmentAdapter.MyViewHolder> {
    Context context;
    private List<AfBean.ArticleDetailBean> list;
    private LayoutInflater mLayoutInflater;

    public AndroidFragmentAdapter(Context context, List<AfBean.ArticleDetailBean> list) {
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AfBean.ArticleDetailBean item = list.get (position);
        holder.tv.setText(item.getauthor());
        holder.tv2.setText(item.getchapterName());
        holder.tv3.setText(item.gettitle());
        holder.tv4.setText(item.getsuperChapterName());
        holder.tv5.setText(item.getniceDate());
        Glide.with(context)
                .load(list.get(position).getenvelopePic()) //加载地址
//                .placeholder(R.drawable.ic_launcher_background)//加载未完成时显示占位图
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.img);//显示的位置

    }

    @Override
    public int getItemCount() {
        if (list==null) {
            return 0;
        }
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
         @BindView(R.id.imageView)
         ImageView img;
         public MyViewHolder(View itemView) {
             super(itemView);
             ButterKnife.bind(this,itemView);
         }
     }
}