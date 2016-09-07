package com.example.nkhiem.viewpagerloop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by nkhiem on 9/7/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PlusOneFragment mFragmentAtPos0; // Fragment at index 0
    public PlusOneFragment mFragmentAtPos1; // Fragment at index 1
    public PlusOneFragment mFragmentAtPos2; // Fragment at index 2
    public final FragmentManager mFragmentManager;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
    }

    @Override
    public PlusOneFragment getItem(int position) {
        Log.e("getItem: ", position + "==================");
        if (position == 0) {
            return mFragmentAtPos0;
        } else if (position == 1) {
            return mFragmentAtPos1;
        }
        return mFragmentAtPos2;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
