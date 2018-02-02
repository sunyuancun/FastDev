package com.syc.fastdev.pic;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.base.fragment.BaseLazyFragment;
import com.example.basecore.mvp.activity.BaseMvpActivity;
import com.example.basecore.mvp.fragment.BaseMvpFragment;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.presenter.BasePresenter;
import com.example.basecore.mvp.view.BaseView;
import com.syc.fastdev.R;

import java.util.List;

public class MeiPicFragment extends BaseMvpFragment<PicPresenter> implements PicView {

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
        getPresenter().getPicTagList();
    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mei_pic, container, false);
        return rootView;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getPicTagList(List<PicTag> list) {

    }

    @Override
    public PicPresenter createPresenter() {
        return new PicPresenter(this);
    }
}
