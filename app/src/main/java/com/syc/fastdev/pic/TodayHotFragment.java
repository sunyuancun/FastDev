package com.syc.fastdev.pic;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.mvp.fragment.BaseMvpFragment;
import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.syc.fastdev.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayHotFragment extends BaseMvpFragment<PicPresenter> implements PicView {


    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {

    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_hot, container, false);
        return view;
    }

    @Override
    public void getPicTagList(List<PicTag> list) {

    }

    @Override
    public void getPortraitList(List<Portrait> list) {

    }

    @Override
    public void getArticle(Article article) {

    }

    @Override
    public PicPresenter createPresenter() {
        return null;
    }
}
