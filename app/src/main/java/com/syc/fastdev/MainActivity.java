package com.syc.fastdev;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.basecore.activity.BaseActivity;
import com.example.basecore.util.ui.UIHelper;


public class MainActivity extends BaseActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.main);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIHelper.startActivity(MainActivity.this, CommonActivity.class, false);
            }
        });
    }

}
