package com.tianzhi.newsapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtil {
	private static int calculateInSampleSize(BitmapFactory.Options options,
			int resWidth, int resHeight) {
		int width = options.outWidth;
		int height = options.outHeight;
		int inSampleSize = 1;
		if (width > resWidth || height > resHeight) {
			final int heightRatio = Math.round((float) height
					/ (float) resHeight);
			final int widthRatio = Math.round((float) width / (float) resWidth);
			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
		}
		return inSampleSize;
	}

	public static Bitmap decodeImage(File file, int resWidth, int resHeight)
			throws IOException {
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeStream(new FileInputStream(file), null, options);
		options.inSampleSize = calculateInSampleSize(options, resWidth,
				resHeight);
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeStream(new FileInputStream(file), null,
				options);
	}

	/**
	 * 以最省内存的方式读取res下的资源的图片
	 */
	public static Bitmap readBitmap(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// 获取资源图片
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}

}
