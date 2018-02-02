package com.example.basecore.net;



import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2017/3/20.
 */

public class BaseResponse<T> {
    @SerializedName(value = "errcode")
    private int errorCode=-1;

    @SerializedName(value = "message")
    private String message;

    @SerializedName(value = "contents")
    private T data;

    public  boolean isSuccess(){
        return errorCode==0;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public T getData() {
        return data;
    }

}
