package com.example.basecore.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.basecore.base.fragment.BaseLazyFragment;
import com.example.basecore.mvp.presenter.BasePresenter;
import com.example.basecore.mvp.view.BaseView;

/**
 * Created by Administrator on 2018/2/2.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseLazyFragment implements BaseView {
    public T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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

    public abstract T createPresenter();


    public T getPresenter() {
        return presenter;
    }
}
