package com.syc.fastdev;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.syc.fastdev.FragmentFactory;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/30.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments;

    public ViewPagerFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
