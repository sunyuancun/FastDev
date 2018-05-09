package com.syc.fastdev.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.basecore.base.activity.BaseActivity;
import com.syc.fastdev.R;
import com.syc.fastdev.helper.AppHelper;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    @Override
    public void initResLayout(View view) {
        TextView tv_version = view.findViewById(R.id.version);
        tv_version.setText("版本号 : "+AppHelper.getVerName(this));
    }
}
