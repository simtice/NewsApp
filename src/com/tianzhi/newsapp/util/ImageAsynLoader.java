package com.tianzhi.newsapp.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

/**
 * 图片异步加载器
 * 
 * @author xxf
 * 
 */
public class ImageAsynLoader {
	private static MemoryCache memoryCache;
	private static ExecutorService executorService;
	private static FileCache fileCache;
	private static Map<ImageView, String> imageViews;
	private boolean isThumb;
	private int resWidth = 100;
	private int resHeight = 100;

	/**
	 * @param context
	 */
	public ImageAsynLoader(Context context) {
		fileCache = new FileCache(Constant.dirName);
	}

	/**
	 * 是否保存在缩略图目录
	 * 
	 * @param isThumb
	 *            true：保存在thumbnails目录下，false:保存在files目录下
	 */
	public void isSaveThumb(boolean isThumb) {
		this.isThumb = isThumb;
	}

	static {
		memoryCache = new MemoryCache();
		executorService = Executors.newFixedThreadPool(5);
		imageViews = Collections
				.synchronizedMap(new WeakHashMap<ImageView, String>());
	}

	/**
	 * 指定宽高从本地读取图片，默认为100
	 * 
	 * @param resWidth
	 * @param resHeight
	 */
	public void setDecodeSize(int resWidth, int resHeight) {
		this.resHeight = resHeight;
		this.resWidth = resWidth;
	}

	/**
	 * 加载图片
	 * 
	 * @param url
	 * @param imageView
	 * @param isLoadOnlyFromCache
	 * @param defaultBitmap
	 */
	public void displayImage(String url, ImageView imageView,
			boolean isLoadOnlyFromCache, Bitmap defaultBitmap) {
		if (!TextUtils.isEmpty(url)) {
			imageViews.put(imageView, url);
			imageView.setImageBitmap(defaultBitmap);
			Bitmap bitmap = memoryCache.get(url);
			if (bitmap != null) {
				imageView.setImageBitmap(bitmap);
			} else
				queueLoad(url, imageView, isLoadOnlyFromCache);

		}

	}

	/**
	 * 创建文件缓存目录
	 */
	public void createFileCacheDir() {
		fileCache.creatCacheDir(isThumb);
	}

	/**
	 * 从本地缓存或者网络加载图片
	 * 
	 * @param url
	 * @param imageView
	 * @param isLoadOnlyFromCache
	 *            是否仅仅从缓存加载图片
	 */
	private void queueLoad(String url, ImageView imageView,
			boolean isLoadOnlyFromCache) {
		if (!fileCache.isCacheDirExis()) {
			createFileCacheDir();
		}

		ImageLoadBean bean = new ImageLoadBean();
		bean.setImageView(imageView);
		bean.setLoadOnlyFromCache(isLoadOnlyFromCache);
		bean.setUrl(url);

		executorService.execute(new GetBitmap(bean));
		// executorService.submit(new GetBitmap(bean));
	}

	/**
	 * 线程获取图片
	 * 
	 * @author simtice
	 * 
	 */
	private class GetBitmap implements Runnable {
		private ImageLoadBean bean;

		public GetBitmap(ImageLoadBean bean) {
			this.bean = bean;
		}

		@Override
		public void run() {
			try {
				if (imageViewReused(bean)) {
					return;
				}
				Bitmap bitmap = getBitmap(bean.getUrl(),
						this.bean.getIsLoadOnlyFromCache());
				if (bitmap != null) {
					memoryCache.put(bean.getUrl(), bitmap);
					Activity activity = (Activity) bean.getImageView()
							.getContext();
					activity.runOnUiThread(new BitmapDisplayer(bitmap, bean));

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 用于在UI线程中更新界面
	class BitmapDisplayer implements Runnable {
		private Bitmap bitmap;
		private ImageLoadBean imageLoadBean;

		public BitmapDisplayer(Bitmap b, ImageLoadBean p) {
			bitmap = b;
			imageLoadBean = p;
		}

		@Override
		public void run() {
			if (imageViewReused(imageLoadBean))
				return;
			imageLoadBean.getImageView().setImageBitmap(bitmap);

		}
	}

	private Bitmap getBitmap(String url, boolean isLoadOnlyFromCache)
			throws IOException {
		File file = fileCache.getFile(url);
		if (file != null && file.exists()) {
			return ImageUtil.decodeImage(file, resWidth, resHeight);
		}
		if (!isLoadOnlyFromCache) {
			downloadImage(url, file);
			return ImageUtil.decodeImage(file, resWidth, resHeight);
		}
		return null;
	}

	private class ImageLoadBean {
		private String url;
		private ImageView imageView;
		private boolean isLoadOnlyFromCache;

		public boolean getIsLoadOnlyFromCache() {
			return isLoadOnlyFromCache;
		}

		public void setLoadOnlyFromCache(boolean isLoadOnlyFromCache) {
			this.isLoadOnlyFromCache = isLoadOnlyFromCache;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public ImageView getImageView() {
			return imageView;
		}

		public void setImageView(ImageView imageView) {
			this.imageView = imageView;
		}

	}

	/**
	 * 清除缓存
	 */
	public void clearCache() {
		memoryCache.clear();
		// fileCache.clear(dirName);
		imageViews.clear();
	}

	/**
	 * 防止图片错位
	 * 
	 * @param imageLoadBean
	 * @return
	 */
	private boolean imageViewReused(ImageLoadBean imageLoadBean) {
		String tag = imageViews.get(imageLoadBean.getImageView());
		if (tag == null || !tag.equals(imageLoadBean.getUrl()))
			return true;
		return false;
	}

	/**
	 * 下载图片
	 * 
	 * @param urlStr
	 * @param file
	 */
	private void downloadImage(final String urlStr, File file) {
		InputStream is = null;
		OutputStream os = null;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			is = connection.getInputStream();
			os = new FileOutputStream(file);
			int count = 0;
			final int bufferSize = 1024;
			byte buffer[] = new byte[bufferSize];

			while ((count = is.read(buffer, 0, bufferSize)) != -1) {
				os.write(buffer, 0, count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null && is != null) {
					os.close();
					is.close();

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
