package com.syc.fastdev;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.syc.fastdev.adapter.ViewPagerFragmentAdapter;
import com.example.basecore.util.ui.StatusBarUtil;

import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements BottomNavigationBar.OnTabSelectedListener {

    BottomNavigationBar bottomNavigationBar;
    ViewPager mViewPager;
    int mDefaultSelectedPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucent(this);
        setContentView(R.layout.activity_main);
        initBottomNavigationBar();
        initViewPager();
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.content_layout);
        mViewPager.setOffscreenPageLimit(10);
        mViewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(pagerChangerListener);
        mViewPager.setCurrentItem(mDefaultSelectedPosition);
    }

    private void initBottomNavigationBar() {
        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar.setBarBackgroundColor(R.color.black);
        bottomNavigationBar.setActiveColor(R.color.colorAccent);
        bottomNavigationBar.setInActiveColor(R.color.white);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.tab_hot, "热点"))
                .addItem(new BottomNavigationItem(R.mipmap.tab_pic, "美图"))
                .addItem(new BottomNavigationItem(R.mipmap.tab_video, "视频"))
                .setFirstSelectedPosition(mDefaultSelectedPosition)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(int position) {
        if (mViewPager != null) {
            mViewPager.setCurrentItem(position);
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    ViewPager.OnPageChangeListener pagerChangerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (bottomNavigationBar != null) {
                bottomNavigationBar.selectTab(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
