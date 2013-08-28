package com.tianzhi.newsapp.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.util.Preferences;

public class NewsDetailAct extends Activity {
	private WebView wView;
	private WebSettings wSet;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_detail);
		wView = (WebView) findViewById(R.id.wv1);
		wSet = wView.getSettings();
		wSet.setJavaScriptEnabled(true);
		wSet.setDefaultTextEncodingName("GBK");
		wView.setWebViewClient(new MyWebviewClient());

		wView.loadUrl("file:///android_asset/22.html");

		TextView title = (TextView) this
				.findViewById(R.id.tv_news_detial_title);
		TextView time = (TextView) this.findViewById(R.id.tv_news_detial_time);
		title.setText("国家主席习近平微服私访乘坐出租车");
		time.setText("2013-5-24 10:22");
		
		setTextSize(Preferences.getTextSize(this));

		// wView.loadUrl("content://com.android.htmlfileprovider/sdcard/index.html");
		// wView.loadUrl("http://wap.baidu.com");
	}

	public void back(View v) {
		this.finish();
	}

	public void menu(View v) {
		String[] items = getResources().getStringArray(R.array.text_size);
		AlertDialog dialog = new AlertDialog.Builder(this).setTitle("字体设置")
				.setItems(items, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						setTextSize(which);
					}
				}).create();
		Window window = dialog.getWindow();
		window.setGravity(Gravity.BOTTOM); // 此处可以设置dialog显示的位置
		window.setWindowAnimations(R.style.dialog); // 添加动画
		dialog.show();
	}

	private void setTextSize(int fontsize) {
		switch (fontsize) {
		case 0:
			wSet.setTextSize(WebSettings.TextSize.LARGER);
			break;

		case 1:
			wSet.setTextSize(WebSettings.TextSize.NORMAL);
			break;
			
		case 2:
			wSet.setTextSize(WebSettings.TextSize.SMALLER);
			break;
		}
		
		Preferences.setTextSize(this, fontsize);
	}

	private class MyWebviewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub
			if (url.contains("loadgroupimg.do")) {
				Intent intent = new Intent(NewsDetailAct.this,
						GroupPicsAct.class);
				intent.putExtra("title", "国家主席习近平微服私访乘坐出租车");
				startActivity(intent);
				return true;
			}
			return super.shouldOverrideUrlLoading(view, url);
		}
	}

}
