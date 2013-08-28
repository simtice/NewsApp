package com.tianzhi.newsapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.tianzhi.newsapp.R;

public class MainActivity extends FragmentActivity implements OnClickListener {
	private TextView tab1;
	private TextView tab2;
	private TextView tab3;
	private TextView tab4;

	private FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getView2Init();

		initFragment(new DingyueFragment());

	}

	/**
	 * 获得布局文件上的控件并初始化
	 */
	private void getView2Init() {
		tab1 = (TextView) findViewById(R.id.tv_main_footer_tab1);
		tab2 = (TextView) findViewById(R.id.tv_main_footer_tab2);
		tab3 = (TextView) findViewById(R.id.tv_main_footer_tab3);
		tab4 = (TextView) findViewById(R.id.tv_main_footer_tab4);

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		tab4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == tab1) {
			updateFragment(new DingyueFragment());
		} else if (v == tab2) {
			updateFragment(new NewsFragment());
		} else if (v == tab3) {
			updateFragment(new PicsFragment());
		}else{
			updateFragment(new MoreFragment());
		}
	}

	/**
	 * 初始化Fragment
	 * 
	 * @param f
	 */
	private void initFragment(Fragment f) {
		fragmentManager = getSupportFragmentManager();
		updateFragment(f);
	}

	/**
	 * 更新Fragment
	 * 
	 * @param f
	 */
	private void updateFragment(Fragment f) {
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.rl_main_content, f);
		ft.commit();
	}

}
