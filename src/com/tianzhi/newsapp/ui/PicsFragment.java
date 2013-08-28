package com.tianzhi.newsapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.adapter.PicsPagerAdapter;
import com.viewpagerindicator.TabPageIndicator;

/**
 * 组图fragment
 * @author xxf
 *
 */
public class PicsFragment extends Fragment {
    private PicsPagerAdapter mAdapter;
    private ViewPager mPager;
    private TabPageIndicator mIndicator;
    private static int mCurrentSubFragmentSeq = 0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tabs_fragment, container, false);
        mAdapter = new PicsPagerAdapter(getFragmentManager(),getActivity());
        mPager = (ViewPager) v.findViewById(R.id.vp_tabs_pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (TabPageIndicator) v.findViewById(R.id.ti_tabs_titles);
        mIndicator.setViewPager(mPager, mCurrentSubFragmentSeq);

        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mCurrentSubFragmentSeq = position;
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return v;
    }
    
}
