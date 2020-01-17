package com.ngapp.cngbelarus.ui.calc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.ngapp.cngbelarus.R;

public class CalcFragment extends Fragment {
    private Context mContext;
    private Activity mActivity;
    private CoordinatorLayout mCLayout;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private AppBarLayout mAppBarLayout;
    private CalcViewModel calcViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calcViewModel =
                ViewModelProviders.of(this).get(CalcViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calc, container, false);

        // Get the application context
        mContext = getActivity().getApplicationContext();
        mActivity = getActivity();

        // Get the widget reference from XML layout
        mCLayout = root.findViewById(R.id.coordinator_layout);
        mToolbar = getActivity().findViewById(R.id.toolbar);
        mTabLayout = root.findViewById(R.id.tab_layout);
        mViewPager = root.findViewById(R.id.view_pager);

        // Set a title for toolbar
         mToolbar.setTitle(getResources().getString(R.string.menu_calc));

        // Set the support action bar
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

//        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize a new instance of PagerAdapter
        PagerAdapter adapter = new SimpleFragmentPagerAdapter(
                getFragmentManager(),
                mActivity
        );

        // Set a PagerAdapter for ViewPager
        mViewPager.setAdapter(adapter);

        // Setup the TabLayout with ViewPager
        mTabLayout.setupWithViewPager(mViewPager);

        mAppBarLayout = getActivity().findViewById(R.id.mAppBarLayout);
        mAppBarLayout.setElevation(0);

        return root;
    }
}