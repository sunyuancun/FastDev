package com.syc.fastdev.pic.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.basecore.mvp.activity.BaseMvpActivity;
import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;
import com.syc.fastdev.pic.PicPresenter;
import com.syc.fastdev.pic.PicView;
import com.syc.fastdev.pic.adapter.PortraitAdapter;

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
        setTitleBarText(picTag.tag_name);
        initView();
    }

    private void initView() {
        requstDataByPage(page);
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mPortraitAdapter = new PortraitAdapter(this, R.layout.item_of_portrait, mPortraitList);
        mRecyclerView.setAdapter(mPortraitAdapter);
        setRecyclerviewFunction();
    }

    private void setRecyclerviewFunction() {
        //Item点击事件
        mPortraitAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Portrait portrait = (Portrait) adapter.getItem(position);
                AppHelper.showPicGallery(PicListByCategoryActivity.this, portrait);
            }
        });
        //加载更多
        mPortraitAdapter.setAutoLoadMoreSize(1);
        mPortraitAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (page < Long.valueOf(picTag.tag_page_num)) {
                    page++;
                    requstDataByPage(page);
                } else {
                    mPortraitAdapter.loadMoreEnd();
                }
            }
        }, mRecyclerView);
    }

    private void requstDataByPage(int page) {
        getPresenter().getPortraitListByTag(picTag.tag_address_root + page);
    }

    @Override
    public void initResLayout(View view) {

    }


    @Override
    public void getPicTagList(List<PicTag> list) {

    }

    @Override
    public void getPortraitList(List<Portrait> list) {
        mPortraitList.addAll(list);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mPortraitAdapter.loadMoreComplete();
    }

    @Override
    public void getArticle(Article article) {

    }
}
