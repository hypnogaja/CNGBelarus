package com.ngapp.cngbelarus.ui.history;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ngapp.cngbelarus.R;


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private Context mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                PhotoHistoryFragment fragment1 = new PhotoHistoryFragment();
                return fragment1;

            case 1:
                VideoHistoryFragment fragment2 = new VideoHistoryFragment();
                return fragment2;

            default:
                PhotoHistoryFragment fragment3 = new PhotoHistoryFragment();
                return fragment3;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        final String photoHistory = mContext.getResources().getString(R.string.photo_history);
        final String videoHistory = mContext.getResources().getString(R.string.video_history);
        final String[] tabTitles = {photoHistory, videoHistory};
        return tabTitles[position];
    }
}
