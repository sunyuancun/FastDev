package com.syc.fastdev.pic;

import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.presenter.BasePresenter;
import com.example.basecore.net.exception.ApiException;
import com.example.basecore.net.service.PicService;
import com.example.basecore.util.log.LogUtil;
import com.example.basecore.util.ui.ToastUtil;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/2/2.
 */

public class PicPresenter extends BasePresenter<PicView> {

    public PicPresenter(PicView mvpView) {
        super(mvpView);
    }

    private String PIC_LIST_BASE_URL = "http://beautyreport.file.alimmdn.com/v4/list_5/";
    private String PIC_TAG_URL = "http://beautyreport.file.alimmdn.com/v4/list_5/mzitu_album_list";

    public void getPicTagList() {
        PicService.getActiveList(PIC_TAG_URL)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Subscriber<List<PicTag>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<PicTag> list) {
                        LogUtil.e(list.size() + "");
                        getMvpView().getPicTagList(list);
                    }
                });
    }


}
