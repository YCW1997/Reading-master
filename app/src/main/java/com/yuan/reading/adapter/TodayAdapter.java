package com.yuan.reading.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuan.reading.R;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.TodayBean;
import com.yuan.reading.fragment.food.ImageActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/3/15 0015.
 */

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MyViewHolder> {
    Context context;
    private List<TodayBean.ResultsBean.AndroidBean> list;
    private LayoutInflater mLayoutInflater;

    public TodayAdapter(Context context, List<TodayBean.ResultsBean.AndroidBean> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TodayAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TodayAdapter.MyViewHolder holder = new TodayAdapter.MyViewHolder(mLayoutInflater.inflate(R.layout.today_fragment_list, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TodayAdapter.MyViewHolder holder, final int position) {
        TodayBean.ResultsBean.AndroidBean item = list.get(position);
        holder.tv.setText(item.getWho());
        holder.tv3.setText(item.getDesc());
        holder.tv4.setText(item.getType() + "/" + item.getSource());
        holder.tv5.setText(item.getPublishedAt());

        if (list.get(position).getImages()!=null) {
            if (list.get(position).getImages().size()==1){
                Glide.with(context)
                        .load(list.get(position).getImages().get(0)) //加载地址
                        .override(500, 500)
                        .into(holder.img);//显示的位置
                holder.img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(TodayAdapter.this.context, ImageActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("list", (ArrayList<String>) list.get(position).getImages());
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }
                });
            }
            if (list.get(position).getImages().size()==2){
                Glide.with(context)
                        .load(list.get(position).getImages().get(0)) //加载地址
                        .override(500, 500)
                        .into(holder.img);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(1)) //加载地址
                        .override(500, 500)
                        .into(holder.img2);//显示的位置
            }
            if (list.get(position).getImages().size()==3){
                Glide.with(context)
                        .load(list.get(position).getImages().get(0)) //加载地址
                        .override(500, 500)
                        .into(holder.img);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(1)) //加载地址
                        .override(500, 500)
                        .into(holder.img2);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(2)) //加载地址
                        .override(500, 500)
                        .into(holder.img3);//显示的位置
            }
            if (list.get(position).getImages().size()==4){
                Glide.with(context)
                        .load(list.get(position).getImages().get(0)) //加载地址
                        .override(500, 500)
                        .into(holder.img);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(1)) //加载地址
                        .override(500, 500)
                        .into(holder.img2);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(2)) //加载地址
                        .override(500, 500)
                        .into(holder.img3);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(3)) //加载地址
                        .override(500, 500)
                        .into(holder.img4);//显示的位置
            }
            if (list.get(position).getImages().size()==5){
                Glide.with(context)
                        .load(list.get(position).getImages().get(0)) //加载地址
                        .override(500, 500)
                        .into(holder.img);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(1)) //加载地址
                        .override(500, 500)
                        .into(holder.img2);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(2)) //加载地址
                        .override(500, 500)
                        .into(holder.img3);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(3)) //加载地址
                        .override(500, 500)
                        .into(holder.img4);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(4)) //加载地址
                        .override(500, 500)
                        .into(holder.img5);//显示的位置
            }
            if (list.get(position).getImages().size()==6){
                Glide.with(context)
                        .load(list.get(position).getImages().get(0)) //加载地址
                        .override(500, 500)
                        .into(holder.img);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(1)) //加载地址
                        .override(500, 500)
                        .into(holder.img2);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(2)) //加载地址
                        .override(500, 500)
                        .into(holder.img3);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(3)) //加载地址
                        .override(70, 70)
                        .into(holder.img4);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(4)) //加载地址
                        .override(500, 500)
                        .into(holder.img5);//显示的位置
                Glide.with(context)
                        .load(list.get(position).getImages().get(5)) //加载地址
                        .override(500, 500)
                        .into(holder.img6);//显示的位置
            }
        }
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
        @BindView(R.id.textView3)
        TextView tv3;
        @BindView(R.id.textView4)
        TextView tv4;
        @BindView(R.id.textView5)
        TextView tv5;
        @BindView(R.id.imageView)
        ImageView img;
        @BindView(R.id.imageView2)
        ImageView img2;
        @BindView(R.id.imageView3)
        ImageView img3;
        @BindView(R.id.imageView4)
        ImageView img4;
        @BindView(R.id.imageView5)
        ImageView img5;
        @BindView(R.id.imageView6)
        ImageView img6;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}