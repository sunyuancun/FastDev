package com.syc.fastdev.pic.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.mvp.fragment.BaseMvpFragment;
import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;
import com.syc.fastdev.pic.activity.PicListByCategoryActivity;
import com.syc.fastdev.pic.PicPresenter;
import com.syc.fastdev.pic.PicView;
import com.syc.fastdev.pic.adapter.TextTagsAdapter;

import java.util.ArrayList;
import java.util.List;

public class PicClassifyFragment extends BaseMvpFragment<PicPresenter> implements PicView {

    TagCloudView tagCloudView;
    List<PicTag> mTagList = new ArrayList<>();
    TextTagsAdapter mTextTagsAdapter;

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pic_classify, container, false);
        tagCloudView = view.findViewById(R.id.tag_cloud_view);
        tagCloudView.setBackgroundColor(Color.WHITE);
        return view;
    }

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
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
