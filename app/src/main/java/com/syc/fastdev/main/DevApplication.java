package com.syc.fastdev.main;

import android.app.Application;

import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.syc.fastdev.helper.AppHelper;

/**
 * Created by Administrator on 2018/5/7.
 */

public class DevApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FeedbackAPI.init(this, AppHelper.AliYun_AppKey, AppHelper.AliYun_AppSecret);
    }
}
