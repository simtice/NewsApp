package com.tianzhi.newsapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.DingyueDetail;

public class DingYueDetailAdapter extends BaseAdapter {
	private ArrayList<DingyueDetail> lists;
	private LayoutInflater inflater;
	private String type;
	public DingYueDetailAdapter(Context context,ArrayList<DingyueDetail> lists,String type){
		this.lists = lists;
		inflater = LayoutInflater.from(context);
		this.type = type;
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
		ViewHolder holder = null;
		if(arg1==null){
			holder = new ViewHolder();
			arg1 = inflater.inflate(R.layout.item_dingyue_detail, null);
			holder.title = (TextView) arg1.findViewById(R.id.tv_item_dingyue_detail_title);
			holder.remark = (TextView) arg1.findViewById(R.id.tv_item_dingyue_detail_remark);
			holder.time = (TextView) arg1.findViewById(R.id.tv_item_dingyue_detail_time);
			holder.type = (TextView) arg1.findViewById(R.id.tv_item_dingyue_detail_type);
			holder.description = (TextView) arg1.findViewById(R.id.tv_item_dingyue_detail_description);
			
			arg1.setTag(holder);
		}else {
			holder = (ViewHolder) arg1.getTag();
		}
		
		holder.remark.setText(lists.get(arg0).getRemark());
		holder.time.setText(lists.get(arg0).getTime());
		holder.title.setText(lists.get(arg0).getTitle());
		holder.type.setText(type);
		String description = lists.get(arg0).getDescription();
		if(!TextUtils.isEmpty(description)){
			holder.description.setVisibility(View.VISIBLE);
			holder.description.setText(description);
		}else{
			holder.description.setVisibility(View.INVISIBLE);
		}
		return arg1;
	}
	
	private class ViewHolder{
		private TextView title;
		private TextView remark;
		private TextView time;
		private TextView type;
		private TextView description;
	}

}
