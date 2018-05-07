package com.syc.fastdev.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.basecore.base.BaseHandler;
import com.syc.fastdev.R;

public class SplashActivity extends Activity implements BaseHandler.BaseHandlerCallBack {
    private final int MSGONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.sendEmptyMessageDelayed(MSGONE,3000);
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

}
