package com.yuan.reading.bean;

public class BaseResponse<T> {
    public int errorCode;
    public String errorMsg;
    public T data;

}
