package com.syc.fastdev.pic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.util.ui.UIHelper;
import com.moxun.tagcloudlib.view.TagsAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/2/7.
 */

public class TextTagsAdapter extends TagsAdapter {

    private List<PicTag> dataSet = new ArrayList<>();
    private Activity activity;

    public TextTagsAdapter(Activity activity, List<PicTag> picTags) {
        this.activity = activity;
        dataSet.clear();
        dataSet = picTags;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public View getView(final Context context, final int position, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setGravity(Gravity.CENTER);
        tv.setText(dataSet.get(position).tag_name);
        tv.setTextColor(Color.WHITE);
        return tv;
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return position % 7;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        view.setBackgroundColor(themeColor);
    }
}
