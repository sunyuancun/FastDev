package com.example.basecore.net.service;


import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.net.HttpManager;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2018/2/2.
 */

public class PicService extends BaseService {

    private interface Api {
        @GET
        Observable<List<PicTag>> getActiveList(@Url String url);
    }

    public static Observable<List<PicTag>> getActiveList(String url) {
        return toSubscribe(HttpManager.getInstance().getService(Api.class).getActiveList(url));
    }

}
