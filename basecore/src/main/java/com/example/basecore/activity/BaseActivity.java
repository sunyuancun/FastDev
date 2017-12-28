package com.example.basecore.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.basecore.R;
import com.example.basecore.views.statusbar.StatusBarKit;

public abstract class BaseActivity extends AppCompatActivity {
    RelativeLayout root_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        root_layout = (RelativeLayout) findViewById(R.id.root_layout);
        setBaseUI();
    }

    private void setBaseUI() {
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarKit.setColor(this, getResources().getColor(R.color.colorPrimary));
//        StatusBarKit.setTransparent(this); //适用于图片浸入状态栏
    }

    /**
     * 重写setContentView，让继承者可以继续设置setContentView
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        View view = getLayoutInflater().inflate(layoutResID, null);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
//        lp.addRule(RelativeLayout.BELOW, R.id.title_line);
        if (null != root_layout) {
            root_layout.addView(view, lp);
        }
    }

}
