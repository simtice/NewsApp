package com.tianzhi.newsapp.ui;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.adapter.ImageLoadAdapter;
import com.tianzhi.newsapp.adapter.NewsSubAdapter;
import com.tianzhi.newsapp.adapter.NoPicsmodeAdapter;
import com.tianzhi.newsapp.beans.NewsListItem;
import com.tianzhi.newsapp.util.Constant;
import com.tianzhi.newsapp.util.Preferences;

/**
 * 新闻Fragment下面的子Fragment
 * 
 * @author xxf
 * 
 */
public class NewsSubFragment extends Fragment {
	private static final String KEY_CONTENT = "Fragment1:Content";
	private Bundle bundle;
	private ArrayList<NewsListItem> lists;
	private ImageLoadAdapter adapter;
	private ListView listView;
	private boolean currentPicmode;// 当前图片模式
	private boolean lastPicmode;
	private int firstVisibleItem;

	public static NewsSubFragment newInstance() {
		final NewsSubFragment fragment = new NewsSubFragment();
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if ((savedInstanceState != null)
				&& savedInstanceState.containsKey(KEY_CONTENT)) {
			bundle = savedInstanceState.getBundle(KEY_CONTENT);
		}

		lists = new ArrayList<NewsListItem>();
		for (int i = 0; i < 20; i++) {
			NewsListItem item = new NewsListItem();
			item.setTitle("曝国家档案局高官送情妇" + (i + 1));
			item.setDescription("网传女主播被国家档案局官员包养4年，该官员现已辞职" + (i + 1));
			item.setCommentNum(i+1);
			item.setFocus(false);
			if(i==5){
				StringBuffer urls = new StringBuffer();
				urls.append(Constant.imageUrls[21]+",");
				urls.append(Constant.imageUrls[22]+",");
				urls.append( Constant.imageUrls[23]);
				item.setUrls(urls.toString());
				item.setNewsType(Constant.news_pics);
				item.setImageNum(5);
				lists.add(item);
				continue;
			}
			item.setListPic(Constant.imageThumbUrls[i]);
			if (i == 0) {
				item.setFocus(true);
			} else
				item.setNewsType(Constant.news_normal);
			
			lists.add(item);
		}
		

		adapter = new NewsSubAdapter(getActivity(), lists);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.news_sub, container, false);
		listView = (ListView) v.findViewById(R.id.single_list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (lists.get(arg2).getNewsType()) {
				case Constant.news_normal:
					getActivity().startActivity(
							new Intent(getActivity(), NewsDetailAct.class));
					break;
				case Constant.news_pics:
					Intent intent = new Intent(getActivity(), PicsNewsAct.class);
					getActivity().startActivity(intent);

					break;
				}
			}
		});

		listView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if (scrollState == SCROLL_STATE_FLING) {
					adapter.setFling(true);
				} else {
					adapter.setFling(false);
					adapter.notifyDataSetChanged();
				}
			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				NewsSubFragment.this.firstVisibleItem = firstVisibleItem;
			}
		});

		return v;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		boolean nopic = Preferences.getPicMode(getActivity());
		currentPicmode = nopic;
		if (lastPicmode == nopic) {
			listView.setSelection(firstVisibleItem);
			return;

		}
		if (nopic) {
			adapter = new NoPicsmodeAdapter(getActivity(), lists);
		} else {
			adapter = new NewsSubAdapter(getActivity(), lists);
		}
		lastPicmode = currentPicmode;
		listView.setAdapter(adapter);

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBundle(KEY_CONTENT, bundle);
	}

}