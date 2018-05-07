package com.syc.fastdev.pic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basecore.base.fragment.BaseLazyFragment;
import com.syc.fastdev.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PicSettingFragment extends BaseLazyFragment {


    public PicSettingFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {

    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pic_setting, container, false);
        return view;
    }

}
