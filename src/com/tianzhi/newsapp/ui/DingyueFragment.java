package com.tianzhi.newsapp.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.adapter.DingYueAdapter;
import com.tianzhi.newsapp.beans.PaperItem;

public class DingyueFragment extends Fragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.dingyue, container, false);
		final ListView lv = (ListView) v.findViewById(R.id.lv_dingyue_list);
		final ArrayList<PaperItem> lists = new ArrayList<PaperItem>();
		String titles[] = { "猜你喜欢", "搜狐早晚报", "欢乐往事", "雷锋网", "虎嗅网", "36氪",
				"TechWeb", "央视财经", "IT时代周刊", "南方周末", "意林" };
		String descriptions[] = { "摇一摇发现更多精彩刊物", "中方被朝扣押渔船和船员获释", "山东车展再现人体彩绘",
				"微软新一代Xbox明日揭晓", "即便将来你戴了一身设备也还得带手机", "好设计与好管家",
				"雅虎新版Flickr亮相", "朝鲜扣押中国渔船", "公务员聘任制让多少人梦碎铁饭碗", "上天堂下地狱",
				"万能的英国使馆" };

		for (int i = 0; i < titles.length; i++) {
			PaperItem beans = new PaperItem();
			beans.setDescription(descriptions[i]);
			beans.setPubTime(System.currentTimeMillis());
			beans.setName(titles[i]);
			lists.add(beans);
		}

		lv.setAdapter(new DingYueAdapter(getActivity(), lists));
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String type = lists.get(arg2).getName();
				Intent intent = new Intent(getActivity(),
						DingYueDetailAct.class);
				intent.putExtra("type", type);
				startActivity(intent);
			}
		});

		return v;
	}

}
