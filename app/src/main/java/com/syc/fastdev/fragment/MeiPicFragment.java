package com.syc.fastdev.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.base.fragment.BaseLazyFragment;
import com.example.basecore.util.ui.LogUtil;
import com.syc.fastdev.R;

public class MeiPicFragment extends BaseLazyFragment {

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {

    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mei_pic, container, false);
        return rootView;
    }

}
