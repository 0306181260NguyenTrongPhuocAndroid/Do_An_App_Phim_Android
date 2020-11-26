package com.example.giaodienchinh;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {

    private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TrangCaNhan();
            case 1:
                return new fragment2();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
