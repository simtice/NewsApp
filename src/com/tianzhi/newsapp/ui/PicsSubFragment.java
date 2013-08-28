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
import android.widget.GridView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.adapter.PicsSubAdapter;
import com.tianzhi.newsapp.beans.GroupPicListItem;
import com.tianzhi.newsapp.util.Constant;

/**
 * 组图Frament下面的子Framgent
 * 
 * @author xxf
 * 
 */
public class PicsSubFragment extends Fragment {

	public static PicsSubFragment newInstance() {
		final PicsSubFragment fragment = new PicsSubFragment();
		return fragment;
	}

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
		View view = inflater.inflate(R.layout.pics, container, false);
		GridView gridView = (GridView) view.findViewById(R.id.gv_pics_grid);
		
		final ArrayList<GroupPicListItem> lists = new ArrayList<GroupPicListItem>();
		for (int i = 0; i < 20; i++) {
			GroupPicListItem item = new GroupPicListItem();
			item.setTitle("揭秘中国隐形富豪" + (i + 1));
			item.setFavoriteNum(i + 1);
			item.setCommentNum(i+1);
			item.setImageNum(i+1);
			item.setListPic(Constant.imageThumbUrls[i]);
			lists.add(item);
		}
		
		final PicsSubAdapter adapter = new PicsSubAdapter(getActivity(), lists); 
		
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent intent = new Intent(getActivity(), GroupPicsAct.class);
				intent.putExtra("title", lists.get(arg2).getTitle());
				if (arg2 % 2 == 0) {
					intent.putExtra("type", 0);
				} else {
					intent.putExtra("type", 1);
				}
				startActivity(intent);
			}

		});
		
		gridView.setOnScrollListener(new OnScrollListener() {
			
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
				
			}
		});
		return view;
	}

}
