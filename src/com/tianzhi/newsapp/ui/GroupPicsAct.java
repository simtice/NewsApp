package com.tianzhi.newsapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.util.CommonUtil;
import com.tianzhi.newsapp.util.Constant;
import com.tianzhi.newsapp.util.ImageAsynLoader;
import com.tianzhi.newsapp.widget.HackyViewPager;
import com.tianzhi.newsapp.widget.PhotoViewAttacher.OnPhotoTapListener;

/**
 * 组图浏览界面
 * 
 * @author xxf
 * 
 */
public class GroupPicsAct extends FragmentActivity implements OnPhotoTapListener{
	private HackyViewPager mPager;
	private ImagePagerAdapter mAdapter;
	private ImageAsynLoader loader;
	private String urls[];
	private String contents[];
	private RelativeLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_detail_pager);
		urls = getIntent().getStringArrayExtra("urls");
		contents = getIntent().getStringArrayExtra("contents");

		if (urls == null) {
			int type = getIntent().getIntExtra("type", 0);
			urls = new String[5];
			if (type == 0) {
				for (int i = 0; i < Constant.imageUrls.length; i++) {
					if (i == urls.length - 1)
						break;
					urls[i] = Constant.imageUrls[i];
				}
			} else {
				urls[0] = Constant.imageUrls[10];
				urls[1] = Constant.imageUrls[11];
				urls[2] = Constant.imageUrls[12];
				urls[3] = Constant.imageUrls[13];
				urls[4] = Constant.imageUrls[14];

			}

		}

		layout = (RelativeLayout) findViewById(R.id.rl_image_detail_layout);
		mAdapter = new ImagePagerAdapter(getSupportFragmentManager(),
				urls.length);
		mPager = (HackyViewPager) findViewById(R.id.hv_image_detail);

		mPager.setAdapter(mAdapter);
		mPager.setOffscreenPageLimit(2);
		final int extraCurrentItem = getIntent().getIntExtra("index", 0);
		mPager.setCurrentItem(extraCurrentItem);

		final TextView content = (TextView) this
				.findViewById(R.id.tv_image_detail_content);
		final TextView index = (TextView) this
				.findViewById(R.id.tv_image_detail_index);
		TextView title = (TextView) this
				.findViewById(R.id.tv_image_detail_title);
		title.setText(getIntent().getStringExtra("title"));
		index.setText((extraCurrentItem + 1) + "/" + urls.length);
		if (contents != null) {
			content.setText(contents[extraCurrentItem]);
		} else {
			content.setText("暂无描述");
		}

		loader = new ImageAsynLoader(this);
		loader.isSaveThumb(false);
		loader.createFileCacheDir();
		loader.setDecodeSize(CommonUtil.getScreenWidth(this),
				CommonUtil.getScreenHeight(this));

		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				index.setText((arg0 + 1) + "/" + urls.length);
				if (contents != null) {
					content.setText(contents[arg0]);
				} else {
					content.setText("暂无描述");
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	private class ImagePagerAdapter extends FragmentStatePagerAdapter {
		private final int mSize;

		public ImagePagerAdapter(FragmentManager fm, int size) {
			super(fm);
			mSize = size;
		}

		@Override
		public int getCount() {
			return mSize;
		}

		@Override
		public Fragment getItem(int position) {
			return ImageDetailFragment.newInstance(urls[position], loader);
		}
	}

	@Override
	public void onPhotoTap(View view, float x, float y) {
		if (layout.getVisibility() == View.GONE) {
			layout.setVisibility(View.VISIBLE);
		} else if (layout.getVisibility() == View.VISIBLE) {
			layout.setVisibility(View.GONE);

		}
	}

}
