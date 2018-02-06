package com.syc.fastdev.pic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syc.fastdev.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayHotFragment extends Fragment {


    public TodayHotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today_hot, container, false);
    }

}
