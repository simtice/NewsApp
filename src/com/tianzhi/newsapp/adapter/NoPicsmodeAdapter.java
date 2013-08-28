package com.tianzhi.newsapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.NewsListItem;

/**
 * 无图模式适配器
 * 
 * @author xxf
 * 
 */
public class NoPicsmodeAdapter extends ImageLoadAdapter {

	private ArrayList<NewsListItem> lists;
	private LayoutInflater inflater;

	public NoPicsmodeAdapter(Context context, ArrayList<NewsListItem> lists) {
		super(context);
		inflater = LayoutInflater.from(context);
		this.lists = lists;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lists.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_news_nopics, null);
			holder.description = (TextView) convertView
					.findViewById(R.id.tv_news_sub_description);
			convertView.setTag(holder);
			holder.commentNum = (TextView) convertView
					.findViewById(R.id.tv_news_sub_remark);
			holder.title = (TextView) convertView
					.findViewById(R.id.tv_news_sub_title);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.description.setText(lists.get(position).getDescription());
		holder.commentNum.setText("评论:"+lists.get(position).getCommentNum());
		holder.title.setText(lists.get(position).getTitle());

		return convertView;
	}

	private static class ViewHolder {
		private TextView description;
		private TextView commentNum;
		private TextView title;

	}
}
