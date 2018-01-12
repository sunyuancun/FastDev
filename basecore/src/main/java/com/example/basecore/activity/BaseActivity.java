package com.example.basecore.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.basecore.R;
import com.example.basecore.util.ui.StatusBarUtil;
import com.example.basecore.util.ui.UIHelper;
import com.example.basecore.util.ui.titlebar.BGATitleBar;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(R.layout.activity_base);
        setBaseUI(layoutResID);
    }

    private void setBaseUI(int layoutResID) {
        //状态栏
        setStatusBar();
        //activity布局
        View view = getLayoutInflater().inflate(layoutResID, null);
        LinearLayout.LayoutParams view_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(view_params);
        //titleBar布局
        BGATitleBar titleBar = new BGATitleBar(this);
        LinearLayout.LayoutParams title_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, UIHelper.dp2px(this, 44));
        titleBar.setLayoutParams(title_params);
        setCommonTitle(titleBar);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        if (null != rootLayout) {
            rootLayout.addView(titleBar);
            rootLayout.addView(view);
        }
    }

    private void setCommonTitle(BGATitleBar titleBar) {
        titleBar.setTitleText(getTitle());
        titleBar.setTitleTextColor(getColor(R.color.white));
        titleBar.setBackgroundColor(getColor(R.color.colorPrimary));
        titleBar.setLeftDrawable(getDrawable(R.drawable.icon_back));

        titleBar.setDelegate(new BGATitleBar.Delegate() {
            @Override
            public void onClickLeftCtv() {
                finish();
            }

            @Override
            public void onClickTitleCtv() {

            }

            @Override
            public void onClickRightCtv() {

            }

            @Override
            public void onClickRightSecondaryCtv() {

            }
        });

    }

    private void setStatusBar() {
        StatusBarUtil.setColor(this, getColor(R.color.colorPrimary));
    }


}
