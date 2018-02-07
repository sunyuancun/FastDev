package com.syc.fastdev.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.syc.fastdev.FragmentFactory;

/**
 * Created by Administrator on 2018/1/30.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    public static final String Type_Main = "main";
    public static final String Type_MeiTu = "pic";

    private String type;

    public ViewPagerFragmentAdapter(FragmentManager fm, String type) {
        super(fm);
        this.type = type;
    }

    @Override
    public Fragment getItem(int position) {

        if (type.equals(Type_Main)) {

            if (position == FragmentFactory.INDEX_HOT) {
                return FragmentFactory.getInstance().createFragment(FragmentFactory.INDEX_HOT, type);
            }

            if (position == FragmentFactory.INDEX_MEINV) {
                return FragmentFactory.getInstance().createFragment(FragmentFactory.INDEX_MEINV, type);
            }

            if (position == FragmentFactory.INDEX_VIDEO) {
                return FragmentFactory.getInstance().createFragment(FragmentFactory.INDEX_VIDEO, type);
            }
        }


        if (type.equals(Type_MeiTu)) {
            if (position == FragmentFactory.INDEX_HOT_TU) {
                return FragmentFactory.getInstance().createFragment(FragmentFactory.INDEX_HOT_TU, type);
            }

            if (position == FragmentFactory.INDEX_CLASSIFY) {
                return FragmentFactory.getInstance().createFragment(FragmentFactory.INDEX_CLASSIFY, type);
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        if (type.equals(Type_Main)) return FragmentFactory.Main_Type_Size;
        if (type.equals(Type_MeiTu)) return FragmentFactory.MeiTu_Type_Size;
        return 0;
    }
}
