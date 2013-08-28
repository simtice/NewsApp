package com.tianzhi.newsapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.util.ImageAsynLoader;
import com.tianzhi.newsapp.util.ImageUtil;

/**
 * 带有图片加载器的适配器
 * 
 * @author xxf
 * 
 */
public class ImageLoadAdapter extends BaseAdapter {
	private ImageAsynLoader loader;
	private Bitmap defaultBitmap;

	public Bitmap getDefaultBitmap() {
		return defaultBitmap;
	}

	public ImageAsynLoader getLoader() {
		return loader;
	}

	// 当前是否正在滑动
	private boolean isFling;

	public void setFling(boolean isFling) {
		this.isFling = isFling;
	}

	public ImageLoadAdapter(Context context) {
		loader = new ImageAsynLoader(context);
		loader.isSaveThumb(true);
		loader.createFileCacheDir();
		loader.setDecodeSize(100, 100);
		defaultBitmap = ImageUtil.readBitmap(context,
				R.drawable.common_default_picbox);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadImage(String url, ImageView imageView, Bitmap defaultBitmap) {
		if (isFling) {// 当前正在滑动，只从缓存读取图片
			loader.displayImage(url, imageView, true, defaultBitmap);
		} else {
			loader.displayImage(url, imageView, false, defaultBitmap);
		}
	}

}
