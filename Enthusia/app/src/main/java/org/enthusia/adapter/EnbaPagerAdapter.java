package org.enthusia.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.enthusia.EnbaFixturesFragment;
import org.enthusia.EnbaPointsFragment;
import org.enthusia.EnbaPoolFragment;
import org.enthusia.EnbaStatsFragment;

public class EnbaPagerAdapter extends FragmentStatePagerAdapter {
    public EnbaPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0)
            return new EnbaFixturesFragment();
        if (position == 1)
            return new EnbaPointsFragment();

        return new EnbaStatsFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Matches";
            case 1:
                return "Table";
            case 2:
                return "MVP";
            default:
                return null;
        }
    }
}