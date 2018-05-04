package com.syc.fastdev;


import android.support.v4.app.Fragment;

import com.syc.fastdev.main.ViewPagerFragmentAdapter;
import com.syc.fastdev.news.HotFragment;
import com.syc.fastdev.pic.fragment.MeiPicFragment;
import com.syc.fastdev.pic.fragment.PicClassifyFragment;
import com.syc.fastdev.pic.fragment.TodayHotFragment;
import com.syc.fastdev.video.VideoFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/30.
 */

public class FragmentFactory {
    private static FragmentFactory mFragmentFactory;
    private Map<String, Fragment> mFragments = new HashMap();
    public static final int INDEX_HOT = 0;
    public static final int INDEX_MEINV = 1;
    public static final int INDEX_VIDEO = 2;
    public static final int Main_Type_Size = 3;

    public static final int INDEX_HOT_TU = 0;
    public static final int INDEX_CLASSIFY = 1;
    public static final int MeiTu_Type_Size = 2;


    public static FragmentFactory getInstance() {
        if (mFragmentFactory == null) {
            mFragmentFactory = new FragmentFactory();
        }
        return mFragmentFactory;
    }


    public Fragment createFragment(int position, String type) {
        Fragment fragment;
        fragment = mFragments.get(type + position);

        if (fragment == null) {

            if (type.equals(ViewPagerFragmentAdapter.Type_Main)) {
                if (position == INDEX_HOT) {
                    fragment = new HotFragment();
                } else if (position == INDEX_MEINV) {
                    fragment = new MeiPicFragment();
                } else if (position == INDEX_VIDEO) {
                    fragment = new VideoFragment();
                }

                if (fragment != null) {
                    mFragments.put(type + position, fragment);
                }

                return fragment;
            }

            if (type.equals(ViewPagerFragmentAdapter.Type_MeiTu)) {
                if (position == INDEX_HOT_TU) {
                    fragment = new TodayHotFragment();
                } else if (position == INDEX_CLASSIFY) {
                    fragment = new PicClassifyFragment();
                }

                if (fragment != null) {
                    mFragments.put(type + position, fragment);
                }

                return fragment;
            }
        }

        return null;

    }

}
