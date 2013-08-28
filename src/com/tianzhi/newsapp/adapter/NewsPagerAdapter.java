package com.tianzhi.newsapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.Channel;
import com.tianzhi.newsapp.ui.NewsSubFragment;

/**
 * 新闻fragment PagerAdapter
 * @author xxf
 *
 */
public class NewsPagerAdapter extends FragmentStatePagerAdapter {
	protected String[] SUB_FRAGMENT; 
	private ArrayList<Channel> lists = new ArrayList<Channel>();
	

	public NewsPagerAdapter(FragmentManager fm ,Context context) {
		super(fm);
		SUB_FRAGMENT = context.getResources().getStringArray(R.array.news_tabs);
		
		for (int i = 0; i < SUB_FRAGMENT.length; i++) {
			Channel channel = new Channel();
			channel.setChannelName(SUB_FRAGMENT[i]);
			lists.add(channel);
		}
	}

	@Override
	public Fragment getItem(int position) {
		return NewsSubFragment.newInstance();
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return lists.get(position).getChannelName();
	}

}
