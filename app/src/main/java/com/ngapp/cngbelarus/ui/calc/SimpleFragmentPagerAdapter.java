package com.ngapp.cngbelarus.ui.calc;

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
                MileageCalcFragment fragment1 = new MileageCalcFragment();
                return fragment1;

            case 1:
                return new PaybackCalcFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        final String mileageCalc = mContext.getResources().getString(R.string.mileage_calculator);
        final String paybackCalc = mContext.getResources().getString(R.string.payback_calculator);
        final String[] tabTitles = {mileageCalc, paybackCalc};
        return tabTitles[position];
    }
}
