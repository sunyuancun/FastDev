package com.syc.fastdev.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.basecore.base.fragment.BaseLazyFragment;
import com.syc.fastdev.R;

public class VideoFragment extends BaseLazyFragment {

    @Override
    protected void initFragmentPrepare() {

    }

    @Override
    protected void initFragmentData() {

    }

    @Override
    protected View initFragmentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_video, container, false);
        return rootview;
    }

}
