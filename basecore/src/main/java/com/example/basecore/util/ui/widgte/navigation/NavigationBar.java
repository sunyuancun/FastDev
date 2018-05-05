package com.example.basecore.util.ui.widgte.navigation;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basecore.R;

/**
 * Created by Administrator on 2018/2/6.
 */

public class NavigationBar extends FrameLayout implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ImageView nav_indicator;
    private TextView tuijian_view, fenlei_view, setting_view;

    public NavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.navigation_bar, this);
        init();
    }

    private void init() {
        fenlei_view = (TextView) findViewById(R.id.fenlei_view);
        tuijian_view = (TextView) findViewById(R.id.tuijian_view);
        setting_view = (TextView) findViewById(R.id.setting_view);
        nav_indicator = (ImageView) findViewById(R.id.nav_indicator);
        nav_indicator.setMaxWidth(getResources().getDisplayMetrics().widthPixels / 3);
        nav_indicator.setMinimumWidth(getResources().getDisplayMetrics().widthPixels / 3);
        tuijian_view.setOnClickListener(this);
        fenlei_view.setOnClickListener(this);
        setting_view.setOnClickListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("Nav_P", "" + position);
        Log.d("Nav_O", "" + positionOffset);
        Log.d("Nav_POP", "" + positionOffsetPixels);
        nav_indicator.setX(position * getResources().getDisplayMetrics().widthPixels / 3 + positionOffsetPixels / 3);
        //getResources().getDisplayMetrics().widthPixels获取屏幕宽度，除以3是因为我的导航栏只有3个，实际情况可以自己改的，这句是关键代码哦
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.tuijian_view) {
            mNavigationBarClickCallBack.navigationBarClick(0);
        }

        if (v.getId() == R.id.fenlei_view) {
            mNavigationBarClickCallBack.navigationBarClick(1);
        }

        if (v.getId() == R.id.setting_view) {
            mNavigationBarClickCallBack.navigationBarClick(2);
        }


    }

    public NavigationBarClickCallBack mNavigationBarClickCallBack;

    public interface NavigationBarClickCallBack {


        void navigationBarClick(int pos);

    }

}
