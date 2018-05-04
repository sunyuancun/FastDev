package com.syc.fastdev.pic.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.basecore.mvp.modal.Portrait;
import com.example.basecore.util.ui.ImageUtils;
import com.lid.lib.LabelImageView;
import com.syc.fastdev.R;


import java.util.List;

/**
 * Created by Administrator on 2018/4/27.
 */

public class PortraitAdapter extends BaseQuickAdapter<Portrait, BaseViewHolder> {

    private Context context;

    public PortraitAdapter(Context context, int layoutResId, @Nullable List<Portrait> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, Portrait item) {
        LabelImageView simpleTagImageView = holder.getView(R.id.image_icon);
        simpleTagImageView.setLabelText(item.album_pics);
        ImageUtils.showPic(context, item.album_thumb, simpleTagImageView);
    }


    @Override
    public void onViewRecycled(BaseViewHolder holder) {
        super.onViewRecycled(holder);
    }
}
