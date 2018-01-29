package com.example.basecore.base.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.basecore.R;
import com.example.basecore.base.intface.BaseView;
import com.example.basecore.util.ui.NetWorkUtil;
import com.example.basecore.util.ui.StatusBarUtil;
import com.example.basecore.util.ui.ToastUtil;


/**
 * Created by Administrator on 2018/1/29.
 */

public abstract class BaseNoTitleActivity extends AppCompatActivity implements BaseView {

    public int mLayoutResID;

    @Override
    public void setContentView(int layoutResID) {
        StatusBarUtil.setTranslucent(this);
        super.setContentView(R.layout.activity_base);
        mLayoutResID = layoutResID;
        if (checkNetWork()) {
            setContentUI(layoutResID);
        }
    }

    private void setContentUI(int layoutResID) {
        //activity布局
        View view = getLayoutInflater().inflate(layoutResID, null);
        LinearLayout.LayoutParams view_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(view_params);
        LinearLayout rootLayout = (LinearLayout) findViewById(R.id.root_layout);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        if (null != rootLayout) {
            rootLayout.removeAllViews();
            rootLayout.addView(view);
            if (layoutResID == mLayoutResID) {
                //暴露给子类初始化view
                initResLayout(view);
            }
        }
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
            if (NetWorkUtil.getNetWorkStates(BaseNoTitleActivity.this) != NetWorkUtil.TYPE_NONE) {
                dimissNetError();
            } else {
                ToastUtil.showShort(BaseNoTitleActivity.this, "请检查网络");
            }
        }
    };
}
