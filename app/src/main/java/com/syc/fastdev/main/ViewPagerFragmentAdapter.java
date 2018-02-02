package com.syc.fastdev.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.syc.fastdev.main.FragmentFactory;

/**
 * Created by Administrator on 2018/1/30.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {


    public ViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == FragmentFactory.INDEX_HOT) {
            return FragmentFactory.createFragment(FragmentFactory.INDEX_HOT);
        }

        if (position == FragmentFactory.INDEX_MEINV) {
            return FragmentFactory.createFragment(FragmentFactory.INDEX_MEINV);
        }

        if (position == FragmentFactory.INDEX_VIDEO) {
            return FragmentFactory.createFragment(FragmentFactory.INDEX_VIDEO);
        }

        return null;
    }

    @Override
    public int getCount() {
        return FragmentFactory.Fragment_Size;
    }
}
