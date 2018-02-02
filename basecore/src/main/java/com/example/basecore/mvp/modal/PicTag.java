package com.example.basecore.mvp.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/2.
 */

public class PicTag implements Serializable {
    @SerializedName("tag_name")
    public String tag_name;
    @SerializedName("tag_address_root")
    public String tag_address_root;
    @SerializedName("tag_page_num")
    public String tag_page_num;
    @SerializedName("classify")
    public String classify;
    @SerializedName("tag_des")
    public String tag_des;

}
