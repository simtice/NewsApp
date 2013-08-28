package com.tianzhi.newsapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.Channel;
import com.tianzhi.newsapp.ui.PicsSubFragment;

/**
 * 组图fragment PagerAdapter
 * @author xxf
 *
 */
public class PicsPagerAdapter extends FragmentStatePagerAdapter {
	protected String[] SUB_FRAGMENT ; 
	private ArrayList<Channel> lists;

	public PicsPagerAdapter(FragmentManager fm,Context context) {
		super(fm);
		SUB_FRAGMENT = context.getResources().getStringArray(R.array.pics_tabs);
		lists = new ArrayList<Channel>();
		for (int i = 0; i < SUB_FRAGMENT.length; i++) {
			Channel channel = new Channel();
			channel.setChannelName(SUB_FRAGMENT[i]);
			lists.add(channel);
		}
		
	}

	@Override
	public Fragment getItem(int position) {
		return PicsSubFragment.newInstance();
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
