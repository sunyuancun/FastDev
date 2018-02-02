package com.example.basecore.mvp.presenter;

import com.example.basecore.mvp.view.BaseView;

import java.lang.ref.WeakReference;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2018/2/2.
 */

public class BasePresenter<V extends BaseView> {
    protected WeakReference<V> mvpViewRef;
    protected CompositeSubscription subscriptions = new CompositeSubscription();

    protected BasePresenter(V mvpView) {
        attachView(mvpView);
    }

    public void attachView(V mvpView) {
        this.mvpViewRef = new WeakReference<V>(mvpView);
    }

    public V getMvpView() {
        return this.mvpViewRef.get();
    }

    public void deatchView() {
        if (!subscriptions.isUnsubscribed()) {
            subscriptions.unsubscribe();
        }
    }
}
