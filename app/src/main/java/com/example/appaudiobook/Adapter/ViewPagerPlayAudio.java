package com.example.appaudiobook.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerPlayAudio extends FragmentPagerAdapter {
    public  final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    public ViewPagerPlayAudio(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }
    public void  addFragment(Fragment fragment){
        fragmentArrayList.add(fragment);
    }
}