package com.tianzhi.newsapp.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.adapter.DingYueDetailAdapter;
import com.tianzhi.newsapp.beans.DingyueDetail;

public class DingYueDetailAct extends Activity {
	private ListView lv;
	private ArrayList<DingyueDetail> lists;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dingyue_detail);
		init();
	}

	private void init() {
		lv = (ListView) this.findViewById(R.id.lv_dingyue_detail_list);
		String type = getIntent().getStringExtra("type");
		TextView typeTextView = (TextView) this.findViewById(R.id.tv_dingyue_detail_type);
		typeTextView.setText(type);
		lists = new ArrayList<DingyueDetail>();
		for (int i = 0; i < 20; i++) {
			DingyueDetail bean = new DingyueDetail();
			bean.setRemark("评论:"+(i+1));
			bean.setTime((i+1)+"分钟前");
			bean.setTitle("中国暴力行业揭秘 化妆品烟草中枪"+(i+1));
			bean.setDescription("SK-II著名神仙水在中国零售价为560元，而其成本仅为6.5元");
			lists.add(bean);
		}
		
		lv.setAdapter(new DingYueDetailAdapter(this, lists,type));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(DingYueDetailAct.this,NewsDetailAct.class));
			}
		});
	}
}
