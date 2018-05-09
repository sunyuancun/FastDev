package com.syc.fastdev.pic.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.example.basecore.base.fragment.BaseLazyFragment;
import com.example.basecore.cache.CacheManager;
import com.example.basecore.util.event.SetPicDataEvent;
import com.example.basecore.util.ui.ToastUtil;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;
import com.syc.fastdev.main.AboutUsActivity;

import org.greenrobot.eventbus.EventBus;

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
        setting_view.setVisibility(View.GONE);
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
                AppHelper.showAboutUSActivity(getActivity());
                break;
            case R.id.share_view:
                break;
            case R.id.setting_view:
//                showSetDataDialog((int) CacheManager.getInstance().getSPCache().get(getActivity(), "DATA", 5));
                break;
            case R.id.feed_view:
                FeedbackAPI.openFeedbackActivity();
                break;
        }
    }

    private void showSetDataDialog(int checkedItem) {
        final String items[] = {"图片源1", "图片源2", "图片源3", "图片源4", "图片源5"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("设置数据源");
        builder.setIcon(R.mipmap.mm_logo);
        builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.show(getActivity(), "选择" + items[which] + "成功", Toast.LENGTH_SHORT);
                CacheManager.getInstance().getSPCache().put(getActivity(), "DATA", which);
                EventBus.getDefault().post(new SetPicDataEvent());
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
