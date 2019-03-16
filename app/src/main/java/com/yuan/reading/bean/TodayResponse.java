package com.yuan.reading.bean;

import java.util.List;

/**
 * Created by Administrator on 2019/3/16 0016.
 */

public class TodayResponse <T>{
    public boolean error;
    public T results;
    public List<String> category;
}
