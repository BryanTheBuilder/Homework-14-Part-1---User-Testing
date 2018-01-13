package nyc.c4q.MovieDBUserTest.controller;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nyc.c4q.MovieDBUserTest.fragments.MoviesFragment;
import nyc.c4q.MovieDBUserTest.fragments.TVFragments;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;

    public FragmentAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numberOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MoviesFragment();
            case 1:
                return new TVFragments();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}