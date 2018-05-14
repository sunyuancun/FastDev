package com.syc.fastdev.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.basecore.base.BaseHandler;
import com.example.basecore.util.ui.NetWorkUtil;
import com.example.basecore.util.ui.ToastUtil;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;

import static com.example.basecore.util.ui.NetWorkUtil.TYPE_NONE;

public class SplashActivity extends Activity implements BaseHandler.BaseHandlerCallBack {
    private final int MSGONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (NetWorkUtil.getNetWorkStates(this) == TYPE_NONE) {
            ToastUtil.showShort(this, "请检查网络");
            this.finish();
            return;
        }
        handler.sendEmptyMessageDelayed(MSGONE,5000);
    }


    private Handler handler = new BaseHandler<>(this);


    @Override
    public void callBack(Message msg) {
        if (msg.what == MSGONE) {
            Intent in = new Intent(SplashActivity.this, MainActivity.class);
            SplashActivity.this.startActivity(in);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeMessages(MSGONE);
            handler = null;
        }
    }
}
