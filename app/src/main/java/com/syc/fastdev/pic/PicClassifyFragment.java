package com.syc.fastdev.pic;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.mvp.fragment.BaseMvpFragment;
import com.example.basecore.mvp.modal.PicTag;
import com.moxun.tagcloudlib.view.TagCloudView;
import com.syc.fastdev.R;

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
        tagCloudView.setBackgroundColor(Color.LTGRAY);
        return view;
    }

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
        mTextTagsAdapter = new TextTagsAdapter(getActivity(),    mTagList);
        tagCloudView.setAdapter(mTextTagsAdapter);
        getPresenter().getPicTagList();
    }

    @Override
    public void getPicTagList(List<PicTag> list) {
        mTagList.clear();
        mTagList.addAll(list);
        mTextTagsAdapter.notifyDataSetChanged();
    }

    @Override
    public PicPresenter createPresenter() {
        return new PicPresenter(this);
    }
}
