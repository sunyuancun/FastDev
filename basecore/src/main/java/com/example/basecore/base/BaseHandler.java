package com.example.basecore.base;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/5/4.
 */

public class BaseHandler<T extends BaseHandler.BaseHandlerCallBack> extends Handler {

    WeakReference<T> wr;

    public BaseHandler(T t) {

        wr = new WeakReference<T>(t);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        T t = wr.get();
        if (t != null)
            t.callBack(msg);
    }

    public interface BaseHandlerCallBack {

        public void callBack(Message msg);
    }
}