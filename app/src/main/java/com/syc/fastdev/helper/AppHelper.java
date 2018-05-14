package com.syc.fastdev.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.FragmentActivity;

import com.example.basecore.mvp.modal.PicTag;
import com.example.basecore.mvp.modal.Portrait;
import com.syc.fastdev.DevApplication;
import com.syc.fastdev.main.AboutUsActivity;
import com.syc.fastdev.pic.activity.PicGalleryActivity;
import com.tencent.bugly.Bugly;

/**
 * Created by Administrator on 2018/4/4.
 */

public class AppHelper {

    public static final String AliYun_AppKey = "24878807";
    public static final String AliYun_AppSecret = "fb4a32c51e25723661d4308b9b960179";

    public static String ONE_ARTICLE_URL = "http://beautyreport.file.alimmdn.com/v4/";
    public static String PIC_PORTRAIT_LIST_URL = "http://beautyreport.file.alimmdn.com/v4/list_5/";
    public static String PIC_TAG_URL = "http://beautyreport.file.alimmdn.com/v4/list_5/mzitu_album_list";
    private static final String Bugly_APPID = "30d081cfc4";


//    public static void setDataUrl(int pos) {
//        ONE_ARTICLE_URL = "http://beautyreport.file.alimmdn.com/v4/";
//        PIC_PORTRAIT_LIST_URL = String.format("http://beautyreport.file.alimmdn.com/v4/list_%d/", pos);
//        PIC_TAG_URL = String.format("http://beautyreport.file.alimmdn.com/v4/list_%d/mzitu_album_list", pos);
//    }

    /**
     * 获取当前本地apk的版本
     *
     * @param mContext
     * @return
     */
    public static int getVersionCode(Context mContext) {
        int versionCode = 0;
        try {
            //获取软件版本号，对应AndroidManifest.xml下android:versionCode
            versionCode = mContext.getPackageManager().
                    getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本号名称
     *
     * @param context 上下文
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }


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

    public static void showAboutUSActivity(Context context) {
        Intent intent = new Intent(context, AboutUsActivity.class);
        context.startActivity(intent);
    }

    public static void initBugly(Context context) {
        Bugly.init(context, Bugly_APPID, false);
    }
}
