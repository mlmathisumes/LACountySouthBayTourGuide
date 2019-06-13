package com.example.lacountysouthbaytourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SingleFragmentPageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public SingleFragmentPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return new SeeFragment();
            case 1:
                return new DoFragment();
            case 2:
                return new EatFragment();
            case 3:
                return new ShopFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
