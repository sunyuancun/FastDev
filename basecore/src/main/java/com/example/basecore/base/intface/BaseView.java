package com.example.basecore.base.intface;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

/**
 * Created by yuancunsun on 2018/1/15.
 */

public interface BaseView {

    /**
     * 展示加载框
     */
    void showLoading();

    /**
     * 取消加载框展示
     */
    void dismissLoading();

    /**
     * 显示网络错误页面
     */
    void showNetError(View.OnClickListener listener);

    /**
     * 网络错误页面，恢复之前的页面
     */
    void dimissNetError();

}
