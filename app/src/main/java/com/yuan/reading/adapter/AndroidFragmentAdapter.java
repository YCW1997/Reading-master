package com.yuan.reading.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuan.reading.R;
import com.yuan.reading.bean.AfBean;
import com.yuan.reading.bean.BaseResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/2 0002.
 */

public class AndroidFragmentAdapter extends BaseAdapter {
    private List<BaseResponse<AfBean>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public AndroidFragmentAdapter(Context context, List<BaseResponse<AfBean>> data){
        this.context=context;
        this.data=data;
        this.layoutInflater= LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     * @author Administrator
     */
    public final class Zujian{
        public TextView tv,tv2,tv3,tv4,tv5;
    }
    @Override
    public int getCount() {
        return data.size();
    }
    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }
    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.android_fragment_list, null);
            zujian.tv=(TextView)convertView.findViewById(R.id.textView);
            zujian.tv2=(TextView)convertView.findViewById(R.id.textView2);
            zujian.tv3=(TextView)convertView.findViewById(R.id.textView3);
            zujian.tv4=(TextView)convertView.findViewById(R.id.textView4);
            zujian.tv5=(TextView)convertView.findViewById(R.id.textView5);
            convertView.setTag(zujian);
        }else{
            zujian=(Zujian)convertView.getTag();
        }
        //绑定数据
        zujian.tv.setText((String)data.get(position).toString());
        zujian.tv2.setText((String)data.get(position).toString());
        zujian.tv3.setText((String)data.get(position).toString());
        zujian.tv4.setText((String)data.get(position).toString());
        zujian.tv5.setText((String)data.get(position).toString());
        return convertView;
    }

}