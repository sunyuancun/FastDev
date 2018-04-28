package com.example.basecore.util.ui;

/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
           佛祖保佑       永无BUG
 */

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2016/10/20.
 */

public class ImageUtils {

    public static void showPic(Context context, String url, ImageView view) {
        Glide.with(context).load(url).override(200, 300).dontAnimate().into(view);
    }

//    public static void showCourseBigLogo(Context context, String url, ImageView view, int defaultImage) {
////        Glide.with(context).load(url).override(720, 400). centerCrop().placeholder(defaultImage).into(view);
//        Glide.with(context).load(url).override(720, 400).centerCrop().placeholder(defaultImage).dontAnimate().into(view);
//
//    }

}
