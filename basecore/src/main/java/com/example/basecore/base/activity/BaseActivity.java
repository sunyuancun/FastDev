package com.example.basecore.base.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.basecore.R;
import com.example.basecore.base.intface.BaseView;
import com.example.basecore.util.ui.NetWorkUtil;
import com.example.basecore.util.ui.widgte.statusBar.StatusBarUtil;
import com.example.basecore.util.ui.ToastUtil;
import com.example.basecore.util.ui.UIHelper;
import com.example.basecore.util.ui.widgte.titlebar.BGATitleBar;


public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    public int mLayoutResID;

    @Override
    public void setContentView(int layoutResID) {
        //状态栏
        StatusBarUtil.setColor(this, this.getResources().getColor(R.color.colorAccent));
        super.setContentView(R.layout.activity_base);
        mLayoutResID = layoutResID;
        if (checkNetWork()) {
            setContentUI(layoutResID);
        }
    }

    BGATitleBar titleBar;

    private void setContentUI(int layoutResID) {
        //activity布局
        View view = getLayoutInflater().inflate(layoutResID, null);
        LinearLayout.LayoutParams view_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(view_params);
        //titleBar布局
        titleBar = new BGATitleBar(this);
        LinearLayout.LayoutParams title_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, UIHelper.dp2px(this, 44));
        titleBar.setLayoutParams(title_params);
        setCommonTitle(titleBar);

        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        if (null != rootLayout) {
            rootLayout.removeAllViews();
            rootLayout.addView(titleBar);
            rootLayout.addView(view);
            if (layoutResID == mLayoutResID) {
                //暴露给子类初始化view
                initResLayout(view);
            }
        }
    }

    /**
     * 设置标题栏
     *
     * @param titleBar
     */
    private void setCommonTitle(BGATitleBar titleBar) {
        titleBar.setTitleText(getTitle());
        titleBar.setTitleTextColor(this.getResources().getColor(R.color.white));
        titleBar.setBackgroundColor(this.getResources().getColor(R.color.colorAccent));
        titleBar.setLeftDrawable(this.getResources().getDrawable(R.drawable.icon_back));
        titleBar.setDelegate(delegate);
    }


    public  void setTitleBarText(String titleBarText){
        titleBar.setTitleText(titleBarText);
    }


    /**
     * 检查网络
     */
    private boolean checkNetWork() {
        if (NetWorkUtil.getNetWorkStates(this) == NetWorkUtil.TYPE_NONE) {
            showNetError(Error_Net_OnclickListener);
            return false;
        }
        return true;
    }

    public abstract void initResLayout(View view);

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showNetError(View.OnClickListener listener) {
        setContentUI(R.layout.net_error_layout);
        LinearLayout net_error = (LinearLayout) findViewById(R.id.net_error);
        net_error.setOnClickListener(listener);
    }

    @Override
    public void dimissNetError() {
        //显示内容页面
        setContentUI(mLayoutResID);
    }

    View.OnClickListener Error_Net_OnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (NetWorkUtil.getNetWorkStates(BaseActivity.this) != NetWorkUtil.TYPE_NONE) {
                dimissNetError();
            } else {
                ToastUtil.showShort(BaseActivity.this, "请检查网络");
            }
        }
    };

    BGATitleBar.Delegate delegate = new BGATitleBar.Delegate() {
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
    };

}
