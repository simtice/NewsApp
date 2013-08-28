package com.tianzhi.newsapp.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.PaperItem;

public class DingYueAdapter extends BaseAdapter{
	private ArrayList<PaperItem> lists;
	private LayoutInflater inflater;
	public DingYueAdapter(Context context,ArrayList<PaperItem> lists){
		this.lists = lists;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return lists.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		HolderView holder = null;
		if(arg1==null){
			holder = new HolderView();
			arg1 = inflater.inflate(R.layout.item_dingyue, null);
			holder.title = (TextView) arg1.findViewById(R.id.tv_item_dingyue_title);
			holder.description = (TextView) arg1.findViewById(R.id.tv_item_dingyue_description);
			holder.time = (TextView) arg1.findViewById(R.id.tv_item_dingyue_time);
			arg1.setTag(holder);
		}else {
			holder = (HolderView) arg1.getTag();
		}
		
		holder.description.setText(lists.get(arg0).getDescription());
		holder.time.setText(getDateByLongTime(lists.get(arg0).getPubTime()));
		holder.title.setText(lists.get(arg0).getName());
		return arg1;
	}
	
	public String getDateByLongTime(long time){
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
		return formatter.format(new java.sql.Timestamp(time));
	}
	
	private class HolderView{
		private TextView title;
		private TextView description;
		private TextView time;
	}

}
