package com.syc.fastdev.pic.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.mvp.fragment.BaseMvpFragment;
import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.example.basecore.util.event.SetPicDataEvent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;
import com.syc.fastdev.pic.activity.PicListByCategoryActivity;
import com.syc.fastdev.pic.PicPresenter;
import com.syc.fastdev.pic.PicView;
import com.syc.fastdev.pic.adapter.TextTagsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class


PicClassifyFragment extends BaseMvpFragment<PicPresenter> implements PicView {
    AdView adView;
    TagCloudView tagCloudView;
    List<PicTag> mTagList = new ArrayList<>();
    TextTagsAdapter mTextTagsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onSetPicDataEvent(SetPicDataEvent event) {
        Log.e("PicClassifyFragment", "event---->");
    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pic_classify, container, false);
        tagCloudView = view.findViewById(R.id.tag_cloud_view);
        tagCloudView.setBackgroundColor(Color.WHITE);
        adView = view.findViewById(R.id.adView);
        return view;
    }

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
        AppHelper.showBannerAdView(adView);
        mTextTagsAdapter = new TextTagsAdapter(getActivity(), mTagList);
        tagCloudView.setAdapter(mTextTagsAdapter);
        tagCloudView.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, int position) {
                PicTag picTag = mTagList.get(position);
                AppHelper.startPicListByCategoryActivity(getActivity(), PicListByCategoryActivity.class, picTag);
            }
        });
        getPresenter().getPicTagList();
    }

    @Override
    public void getPicTagList(List<PicTag> list) {
        mTagList.clear();
        mTagList.addAll(list);
        mTextTagsAdapter.notifyDataSetChanged();
    }

    @Override
    public void getPortraitList(List<Portrait> list) {

    }

    @Override
    public void getArticle(Article article) {

    }

    @Override
    public PicPresenter createPresenter() {
        return new PicPresenter(this);
    }
}
