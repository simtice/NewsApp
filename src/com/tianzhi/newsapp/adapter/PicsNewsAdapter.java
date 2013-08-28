package com.tianzhi.newsapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.Photo;

/**
 * 图片新闻样式适配器
 * @author xxf
 *
 */
public class PicsNewsAdapter extends ImageLoadAdapter {

	private ArrayList<Photo> lists;
	private LayoutInflater inflater;

	public PicsNewsAdapter(ArrayList<Photo> lists, Context context) {
		super(context);
		this.lists = lists;
		inflater = LayoutInflater.from(context);
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
			convertView = inflater.inflate(R.layout.item_pics_news, null);
			holder = new ViewHolder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.iv_item_pics_news_image);
			holder.context = (TextView) convertView
					.findViewById(R.id.iv_item_pics_news_content);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		this.loadImage(lists.get(position).getPicUrl(), holder.image, this.getDefaultBitmap());
		String content = lists.get(position).getDescription();

		if (!TextUtils.isEmpty(content))
			holder.context.setText(content);

		return convertView;
	}

	private static class ViewHolder {
		private ImageView image;
		private TextView context;
	}

}
