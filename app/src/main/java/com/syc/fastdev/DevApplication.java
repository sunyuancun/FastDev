package com.syc.fastdev;

import android.app.Application;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.example.basecore.cache.CacheManager;
import com.syc.fastdev.helper.AppHelper;

/**
 * Created by Administrator on 2018/5/7.
 */

public class DevApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppHelper.initBugly(this);
        FeedbackAPI.init(this, AppHelper.AliYun_AppKey, AppHelper.AliYun_AppSecret);
    }
}
