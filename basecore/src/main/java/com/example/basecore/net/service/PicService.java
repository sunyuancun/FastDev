package com.example.basecore.net.service;


import com.example.basecore.APPConfig;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.net.BaseResponse;
import com.example.basecore.net.HttpManager;

import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/2.
 */

public class PicService extends BaseService {

    private interface Api {
        @GET("/v4/list_5/mzitu_album_list")
        Observable<List<PicTag>> getActiveList();
    }

    public static Observable<List<PicTag>> getActiveList() {
        return toSubscribe(HttpManager.getInstance().getService(Api.class).getActiveList());
    }

}
