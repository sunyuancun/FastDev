package com.syc.fastdev.helper;

import android.content.Context;
import android.content.Intent;

import com.example.basecore.mvp.modal.PicTag;

/**
 * Created by Administrator on 2018/4/4.
 */

public class AppHelper {

    public static void startPicListByCategoryActivity(Context context, Class cls, PicTag tag) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("PicTag", tag);
        context.startActivity(intent);
    }

}
