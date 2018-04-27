package com.syc.fastdev.pic;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.basecore.mvp.activity.BaseMvpActivity;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.example.basecore.util.log.LogUtil;
import com.example.basecore.util.ui.widgte.titlebar.BGATitleBar;
import com.syc.fastdev.R;

import java.util.ArrayList;
import java.util.List;


public class PicListByCategoryActivity extends BaseMvpActivity<PicPresenter> implements PicView {

    PicTag picTag;
    private int page = 1;
    private RecyclerView mRecyclerView;
    private List<Portrait> mPortraitList = new ArrayList<>();
    PortraitAdapter mPortraitAdapter;

    @Override
    public PicPresenter createPresenter() {
        return new PicPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_list_category);
        picTag = (PicTag) getIntent().getSerializableExtra("PicTag");
        initView();
    }

    private void initView() {
        requstDataByPage(page);
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mPortraitAdapter = new PortraitAdapter(this, R.layout.item_of_portrait, mPortraitList);
        mRecyclerView.setAdapter(mPortraitAdapter);
    }

    private void requstDataByPage(int page) {
        getPresenter().getPortraitListByTag(picTag.tag_address_root + page);
    }

    @Override
    public void initResLayout(View view) {

    }

    @Override
    public void setTitleBarByActivity(BGATitleBar titleBar) {

    }

    @Override
    public void getPicTagList(List<PicTag> list) {

    }

    @Override
    public void getPortraitList(List<Portrait> list) {
        mPortraitList.addAll(list);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
