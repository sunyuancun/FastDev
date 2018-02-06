package com.syc.fastdev.pic;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.base.fragment.BaseLazyFragment;
import com.example.basecore.util.ui.widgte.navigation.NavigationBar;
import com.syc.fastdev.R;
import com.syc.fastdev.main.ViewPagerFragmentAdapter;

import java.util.Arrays;
import java.util.List;

public class MeiPicFragment extends BaseLazyFragment implements NavigationBar.NavigationBarClickCallBack {

    ViewPager view_pager;
    NavigationBar navigationBar;

    private static final String[] CHANNELS = new String[]{"热图", "分类"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mei_pic, container, false);
        navigationBar = (NavigationBar) rootView.findViewById(R.id.magic_indicator);
        navigationBar.mNavigationBarClickCallBack = this;
        view_pager = (ViewPager) rootView.findViewById(R.id.view_pager);
        view_pager.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), ViewPagerFragmentAdapter.Type_MeiTu));
        view_pager.addOnPageChangeListener(navigationBar);
        return rootView;
    }

    @Override
    public void navigationBarClick(int pos) {
        view_pager.setCurrentItem(pos);
    }
}
