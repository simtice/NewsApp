
package com.tianzhi.newsapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Preferences {

	public static final String PREFERENCE_PICMODE = "picmode"; // 图片模式 true:无图模式
	public static final String PREFERENCE_TEXTSISE = "textsize"; // 文字大小 0:大 1:中
																	// 2:小

	public static Boolean getPicMode(Context context) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		return prefs.getBoolean(PREFERENCE_PICMODE, false);
	}

	public static int getTextSize(Context context) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		return prefs.getInt(PREFERENCE_TEXTSISE, 0);
	}

	public static void setPicMode(Context context,boolean picmode) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = prefs.edit();
		editor.putBoolean(PREFERENCE_PICMODE, picmode);
		editor.commit();
	}

	public static void setTextSize(Context context, int size) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		Editor editor = prefs.edit();
		editor.putInt(PREFERENCE_TEXTSISE, size);
		editor.commit();
	}

}
