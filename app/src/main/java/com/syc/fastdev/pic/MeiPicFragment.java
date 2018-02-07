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

public class MeiPicFragment extends BaseLazyFragment implements NavigationBar.NavigationBarClickCallBack {

    ViewPager view_pager;
    NavigationBar navigationBar;

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {
    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mei_pic, container, false);
        navigationBar = rootView.findViewById(R.id.magic_indicator);
        navigationBar.mNavigationBarClickCallBack = this;
        view_pager = rootView.findViewById(R.id.view_pager);
        view_pager.setAdapter(new ViewPagerFragmentAdapter(getFragmentManager(), ViewPagerFragmentAdapter.Type_MeiTu));
        view_pager.addOnPageChangeListener(navigationBar);
        return rootView;
    }

    @Override
    public void navigationBarClick(int pos) {
        view_pager.setCurrentItem(pos);
    }
}
