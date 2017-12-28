package com.syc.fastdev;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.basecore.activity.BaseActivity;


public class MainActivity extends BaseActivity {
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv);
    }

}
