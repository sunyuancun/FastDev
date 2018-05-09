package com.syc.fastdev.helper;


import android.support.v4.app.Fragment;

import com.syc.fastdev.news.HotFragment;
import com.syc.fastdev.pic.fragment.MeiPicFragment;
import com.syc.fastdev.pic.fragment.PicClassifyFragment;
import com.syc.fastdev.pic.fragment.PicSettingFragment;
import com.syc.fastdev.pic.fragment.PicHotFragment;
import com.syc.fastdev.video.VideoFragment;

import java.util.ArrayList;
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

    public static final int INDEX_HOT_TU = 0;
    public static final int INDEX_CLASSIFY = 1;
    public static final int INDEX_SETTING = 2;

    public static FragmentFactory getInstance() {
        if (mFragmentFactory == null) {
            mFragmentFactory = new FragmentFactory();
        }
        return mFragmentFactory;
    }


    public ArrayList<Fragment> createMainFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        HotFragment hot_fragment = new HotFragment();
        MeiPicFragment pic_fragment = new MeiPicFragment();
        VideoFragment video_fragment = new VideoFragment();
        fragments.add(FragmentFactory.INDEX_HOT, hot_fragment);
        fragments.add(FragmentFactory.INDEX_MEINV, pic_fragment);
        fragments.add(FragmentFactory.INDEX_VIDEO, video_fragment);
        return fragments;
    }

    public ArrayList<Fragment> createPicFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        PicHotFragment picHotFragment = new PicHotFragment();
        PicClassifyFragment picClassifyFragment = new PicClassifyFragment();
        PicSettingFragment picSettingFragment = new PicSettingFragment();
        fragments.add(FragmentFactory.INDEX_HOT_TU, picHotFragment);
        fragments.add(FragmentFactory.INDEX_CLASSIFY, picClassifyFragment);
        fragments.add(FragmentFactory.INDEX_SETTING, picSettingFragment);
        return fragments;
    }

}
