package com.example.basecore.mvp.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/26.
 */

public class Portrait implements Serializable {
    @SerializedName("album_name")
    public String album_name;
    @SerializedName("album_address")
    public String album_address;
    @SerializedName("album_refer")
    public String album_refer;
    @SerializedName("album_thumb")
    public String album_thumb;
    @SerializedName("album_pics")
    public String album_pics;
    @SerializedName("album_width")
    public String album_width;
    @SerializedName("album_height")
    public String album_height;
}
