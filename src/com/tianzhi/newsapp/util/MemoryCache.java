package com.tianzhi.newsapp.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;

public class MemoryCache {
	private long maxMemSize;// 最大内存大小
	private long currentMemSize;// 当前已经使用的内存大小
	private Map<String, Bitmap> cache;

	public MemoryCache() {
		maxMemSize = Runtime.getRuntime().maxMemory() / 10;
		// 放入缓存时是个同步操作
		// LinkedHashMap构造方法的最后一个参数true代表这个map里的元素将按照最近使用次数由少到多排列，即LRU
		// 这样的好处是如果要将缓存中的元素替换，则先遍历出最近最少使用的元素来替换以提高效率
		cache = Collections.synchronizedMap(new LinkedHashMap<String, Bitmap>(
				10, 1.5f, true));
	}

	public Bitmap get(String url) {
		if (cache.containsKey(url)) {
			return cache.get(url);
		}
		return null;
	}

	public void put(String url, Bitmap bitmap) {
		if (!cache.containsKey(url)) {
			cache.put(url, bitmap);
			currentMemSize += sizeOf(bitmap);
		}
		checkMemSize();
	}

	/**
	 * 严格控制堆内存，如果超过将首先替换最近最少使用的那个图片缓存
	 */
	private void checkMemSize() {
		if (currentMemSize > maxMemSize) {
			// 先遍历最近最少使用的元素
			Iterator<Entry<String, Bitmap>> iterator = cache.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Entry<String, Bitmap> entry = iterator.next();
				iterator.remove();
				currentMemSize -= sizeOf(entry.getValue());
				if (currentMemSize <= maxMemSize) {
					break;
				}
			}
		}
	}

	/**
	 * 清空缓存
	 */
	public void clear() {
		cache.clear();
		currentMemSize = 0;
	}

	/**
	 * 获取bitmap所占用的大小
	 * 
	 * @param bitmap
	 * @return
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	protected long sizeOf(Bitmap bitmap) {
		if (bitmap == null) {
			return 0;
		} else {
			if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR1) {
				return bitmap.getRowBytes() * bitmap.getHeight();
			} else {
				return bitmap.getByteCount();
			}
		}
	}

}
