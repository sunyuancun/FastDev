package com.syc.fastdev.main;


import android.support.v4.app.Fragment;

import com.syc.fastdev.news.HotFragment;
import com.syc.fastdev.pic.MeiPicFragment;
import com.syc.fastdev.video.VideoFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/30.
 */

public class FragmentFactory {


    private static Map<Integer, Fragment> mFragments = new HashMap<Integer, Fragment>();
    public static final int INDEX_HOT = 0;
    public static final int INDEX_MEINV = 1;
    public static final int INDEX_VIDEO = 2;
    public static final int Fragment_Size = 3;


    public static Fragment createFragment(int position) {
        Fragment fragment = null;
        fragment = mFragments.get(position);  //在集合中取出来Fragment

        if (fragment == null) {

            if (position == INDEX_HOT) {
                fragment = new HotFragment();
            } else if (position == INDEX_MEINV) {
                fragment = new MeiPicFragment();
            } else if (position == INDEX_VIDEO) {
                fragment = new VideoFragment();
            }

            if (fragment != null) {
                mFragments.put(position, fragment);
            }

        }

        return fragment;

    }

}
