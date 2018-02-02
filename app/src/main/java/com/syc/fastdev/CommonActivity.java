package com.syc.fastdev;

import android.os.Bundle;
import android.view.View;

import com.example.basecore.base.activity.BaseActivity;
import com.example.basecore.mvp.activity.BaseMvpActivity;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.util.ui.titlebar.BGATitleBar;
import com.syc.fastdev.pic.PicPresenter;
import com.syc.fastdev.pic.PicView;

import java.util.List;


public class CommonActivity extends BaseMvpActivity<PicPresenter> implements PicView {

    @Override
    public PicPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
    }

    @Override
    public void initResLayout(View view) {

    }

    @Override
    public void setTitleBarByActivity(BGATitleBar titleBar) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getPicTagList(List<PicTag> list) {

    }
}
