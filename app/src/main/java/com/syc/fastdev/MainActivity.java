package com.syc.fastdev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.basecore.base.activity.BaseActivity;
import com.example.basecore.base.activity.BaseNoTitleActivity;
import com.example.basecore.util.ui.StatusBarUtil;
import com.example.basecore.util.ui.ToastUtil;
import com.example.basecore.util.ui.UIHelper;
import com.example.basecore.util.ui.titlebar.BGATitleBar;


public class MainActivity extends BaseNoTitleActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initResLayout(View view) {
        layout = (LinearLayout) findViewById(R.id.main);
        layout.setOnClickListener(v -> {
            UIHelper.startActivity(MainActivity.this, CommonActivity.class, false);
        });
    }
}
