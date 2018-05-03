package com.example.basecore.mvp.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/3.
 */

public class Article implements Serializable {

    @SerializedName("des")
    public String des;
    @SerializedName("adress")
    public String adress;
    @SerializedName("hide")
    public int hide;
    @SerializedName("summarize")
    public String summarize;
    @SerializedName("pic_total")
    public ArrayList<PicInfo> pics;


    public class PicInfo {
        @SerializedName("pic_url")
        public String pic_url;
        @SerializedName("pic_name")
        public String pic_name;
        @SerializedName("width")
        public long width;
        @SerializedName("height ")
        public long height;


    }


}
