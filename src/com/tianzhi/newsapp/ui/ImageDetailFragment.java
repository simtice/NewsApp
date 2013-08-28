/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tianzhi.newsapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.util.CommonUtil;
import com.tianzhi.newsapp.util.ImageAsynLoader;
import com.tianzhi.newsapp.widget.PhotoView;
import com.tianzhi.newsapp.widget.PhotoViewAttacher.OnPhotoTapListener;

/**组图浏览界面每一页是一个Fragment
 * This fragment will populate the children of the ViewPager from
 * {@link ImageDetailActivity}.
 */
public class ImageDetailFragment extends Fragment {

	private String mImageUrl;
	private PhotoView mImageView;
	public ImageAsynLoader loader;

	/**
	 * Factory method to generate a new instance of the fragment given an image
	 * number.
	 * 
	 * @param imageUrl
	 *            The image url to load
	 * @return A new instance of ImageDetailFragment with imageNum extras
	 */
	public static ImageDetailFragment newInstance(String imageUrl, ImageAsynLoader loader) {
		final ImageDetailFragment f = new ImageDetailFragment(imageUrl, loader);

		// final Bundle args = new Bundle();
		// args.putString(IMAGE_DATA_EXTRA, imageUrl);
		// args.putString(LOADER, imageUrl);
		// args.put
		// f.setArguments(args);

		return f;
	}

	/**
	 * Empty constructor as per the Fragment documentation
	 */
	public ImageDetailFragment(String imageUrl, ImageAsynLoader loader) {
		this.loader = loader;
		this.mImageUrl = imageUrl;
	}

	/**
	 * Populate image using a url from extras, use the convenience factory
	 * method {@link ImageDetailFragment#newInstance(String)} to create this
	 * fragment.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		mImageUrl = getArguments() != null ? getArguments().getString(
//				IMAGE_DATA_EXTRA) : null;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.image_detail_fragment,
				container, false);
		mImageView = (PhotoView) v.findViewById(R.id.pv_imagedetail);
//		
		
		//处理父Activity的点击事件
		if (OnPhotoTapListener.class.isInstance(getActivity())) {
			mImageView.setOnPhotoTapListener((OnPhotoTapListener) getActivity());
		}
		
		int resWidth = CommonUtil.getScreenWidth(getActivity());
		int resHeight = CommonUtil.getScreenHeight(getActivity());
		
		this.loader.setDecodeSize(resWidth, resHeight);
		
		this.loader.displayImage(mImageUrl, mImageView, false,null);
		
		return v;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
	}

}
