package com.syc.fastdev.pic;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.basecore.mvp.fragment.BaseMvpFragment;
import com.example.basecore.mvp.modal.Article;
import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayHotFragment extends BaseMvpFragment<PicPresenter> implements PicView {
    private int page = 1;
    private RecyclerView mRecyclerView;
    private List<Portrait> mPortraitList = new ArrayList<>();
    PortraitAdapter mPortraitAdapter;

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mPortraitAdapter = new PortraitAdapter(getActivity(), R.layout.item_of_portrait, mPortraitList);
        mRecyclerView.setAdapter(mPortraitAdapter);
        ((PortraitAdapter) mRecyclerView.getAdapter()).setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Portrait portrait = (Portrait) adapter.getItem(position);
                AppHelper.showPicGallery(getActivity(), portrait);
            }
        });
        requstDataByPage(page);
    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today_hot, container, false);
        mRecyclerView = view.findViewById(R.id.list);
        return view;
    }

    private void requstDataByPage(int page) {
        getPresenter().getPortraitListByTag("album_data/total_page_" + page);
    }


    @Override
    public void getPicTagList(List<PicTag> list) {

    }

    @Override
    public void getPortraitList(List<Portrait> list) {
        mPortraitList.addAll(list);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void getArticle(Article article) {

    }

    @Override
    public PicPresenter createPresenter() {
        return new PicPresenter(this);
    }
}
