package com.yuan.reading.bean;

import java.util.List;

public class BaseResponse<T> {
    public int errorCode;
    public String errorMsg;
    public T data;
    private List<AfBean> datas;

    public List<AfBean> getDatas() {
        return datas;
    }
}
