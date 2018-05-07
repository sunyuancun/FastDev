package com.syc.fastdev.pic.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.example.basecore.base.fragment.BaseLazyFragment;
import com.syc.fastdev.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PicSettingFragment extends BaseLazyFragment implements View.OnClickListener {


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
        TextView setting_view = view.findViewById(R.id.setting_view);
        TextView share_view = view.findViewById(R.id.share_view);
        TextView feed_view = view.findViewById(R.id.feed_view);
        TextView about_view = view.findViewById(R.id.about_view);
        setting_view.setOnClickListener(this);
        share_view.setOnClickListener(this);
        feed_view.setOnClickListener(this);
        about_view.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.about_view:
                break;
            case R.id.share_view:
                break;
            case R.id.setting_view:
                break;
            case R.id.feed_view:
                FeedbackAPI.openFeedbackActivity();
                break;
        }
    }
}
