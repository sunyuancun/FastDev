package com.syc.fastdev.pic;

import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.presenter.BasePresenter;
import com.example.basecore.net.exception.ApiException;
import com.example.basecore.net.service.PicService;
import com.example.basecore.util.log.LogUtil;
import com.example.basecore.util.ui.ToastUtil;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/2/2.
 */

public class PicPresenter extends BasePresenter<PicView> {

    public PicPresenter(PicView mvpView) {
        super(mvpView);
    }


    public void getPicTagList() {
        PicService.getActiveList().subscribe(new Subscriber<List<PicTag>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtil.e(e.getMessage());
            }

            @Override
            public void onNext(List<PicTag> list) {
                LogUtil.e(list.size() + "");
                getMvpView().getPicTagList(list);
            }
        });
    }


}
