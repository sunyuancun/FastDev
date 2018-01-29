package com.syc.fastdev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.basecore.base.activity.BaseActivity;
import com.example.basecore.util.ui.titlebar.BGATitleBar;


public class CommonActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
    }

    @Override
    public void initResLayout(View view) {

    }

    @Override
    public void setTitleBarByActivity(BGATitleBar titleBar) {

    }
}
