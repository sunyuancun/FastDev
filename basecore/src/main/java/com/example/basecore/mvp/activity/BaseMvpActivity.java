package com.example.basecore.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.basecore.base.activity.BaseActivity;
import com.example.basecore.base.intface.BaseView;
import com.example.basecore.mvp.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/2/2.
 */

public abstract class BaseMvpActivity<P extends BasePresenter> extends BaseActivity implements BaseView {
    public P presenter;
    public abstract P createPresenter();
    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatchView();
        }
    }

}
