package com.syc.fastdev.pic;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.basecore.mvp.modal.Portrait;
import com.syc.fastdev.R;

import net.wujingchao.android.view.SimpleTagImageView;

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
    protected void convert(BaseViewHolder helper, Portrait item) {
        SimpleTagImageView simpleTagImageView = helper.getView(R.id.image_icon);
        simpleTagImageView.setTagText(item.album_name);
    }
}
