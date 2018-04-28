package com.syc.fastdev.helper;

import android.content.Context;
import android.content.Intent;

import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.syc.fastdev.pic.PicGalleryActivity;

/**
 * Created by Administrator on 2018/4/4.
 */

public class AppHelper {

    public static void startPicListByCategoryActivity(Context context, Class cls, PicTag tag) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("PicTag", tag);
        context.startActivity(intent);
    }

    public static void showPicGallery(Context context, Portrait portrait) {
        Intent intent = new Intent(context, PicGalleryActivity.class);
        intent.putExtra("Portrait", portrait);
        context.startActivity(intent);

    }
}
