package com.nanocomputing.bettips.Adapters;

/**
 * Created by Tonui on 3/15/2017.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nanocomputing.bettips.fragments.DailyTips;
import com.nanocomputing.bettips.fragments.JackPotTips;
import com.nanocomputing.bettips.fragments.MegaJackPotTips;
import com.nanocomputing.bettips.fragments.Under25Tips;
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    private int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if (position == 0) // if the position is 0 we are returning the First tab
        {
            DailyTips dailyTips = new DailyTips();
            return dailyTips;
            }
            else if (position == 1) {
            JackPotTips jackPotTips = new JackPotTips();
            return jackPotTips;
             }
            else if (position == 2) {
                Under25Tips jackPotTips = new Under25Tips();
                return jackPotTips;
            }
                else
            {
                MegaJackPotTips megaJackPotTips = new MegaJackPotTips();
                return megaJackPotTips;
            }

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
