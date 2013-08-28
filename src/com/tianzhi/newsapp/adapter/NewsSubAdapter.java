package com.tianzhi.newsapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tianzhi.newsapp.R;
import com.tianzhi.newsapp.beans.NewsListItem;
import com.tianzhi.newsapp.util.CommonUtil;
import com.tianzhi.newsapp.util.Constant;

/**
 * 新闻界面下子新闻列表适配器
 */
public class NewsSubAdapter extends ImageLoadAdapter {
	private ArrayList<NewsListItem> lists;
	private LayoutInflater inflater;

	public NewsSubAdapter(Context context, ArrayList<NewsListItem> lists) {
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

	// 重写 getItemViewType(int) – 根据position返回相应的Item
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return lists.get(position).getNewsType();
	}

	// 返回多少个不同的布局
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		NewsListItem bean = lists.get(position);
		int type = getItemViewType(position);

		ViewHolderType1 holder1 = null;
		ViewHolderType2 holder2 = null;
		ViewHolderType3 holder3 = null;
		if (convertView == null) {

			if (bean.isFocus()) {
				holder3 = new ViewHolderType3();
				convertView = inflater.inflate(R.layout.item_news_top, null);
				holder3.image = (ImageView) convertView
						.findViewById(R.id.iv_news_sub_image);
				holder3.title = (TextView) convertView
						.findViewById(R.id.tv_news_sub_title);
				convertView.setTag(holder3);
			} else {
				switch (type) {
				case Constant.news_normal:
					holder1 = new ViewHolderType1();
					convertView = inflater.inflate(R.layout.item_news_normal,
							null);
					holder1.description = (TextView) convertView
							.findViewById(R.id.tv_news_sub_description);
					convertView.setTag(holder1);
					holder1.commentNum = (TextView) convertView
							.findViewById(R.id.tv_news_sub_remark);
					holder1.title = (TextView) convertView
							.findViewById(R.id.tv_news_sub_title);
					holder1.iamge = (ImageView) convertView
							.findViewById(R.id.iv_news_sub_image);
					break;
				case Constant.news_pics:
					holder2 = new ViewHolderType2();
					convertView = inflater.inflate(R.layout.item_news_pics,
							null);
					holder2.pics = (TextView) convertView
							.findViewById(R.id.tv_news_sub_pics);
					holder2.pics1 = (ImageView) convertView
							.findViewById(R.id.iv_news_sub_pic1);
					holder2.pics2 = (ImageView) convertView
							.findViewById(R.id.iv_news_sub_pic2);
					holder2.pics3 = (ImageView) convertView
							.findViewById(R.id.iv_news_sub_pic3);
					holder2.commentNum = (TextView) convertView
							.findViewById(R.id.tv_news_sub_remark);
					holder2.title = (TextView) convertView
							.findViewById(R.id.tv_news_sub_title);
					convertView.setTag(holder2);
					break;
				}
			}

		} else {
			if (bean.isFocus()) {
				holder3 = (ViewHolderType3) convertView.getTag();
			} else {
				switch (type) {
				case Constant.news_normal:
					holder1 = (ViewHolderType1) convertView.getTag();
					break;

				case Constant.news_pics:
					holder2 = (ViewHolderType2) convertView.getTag();
					break;
				}
			}

		}

		if (bean.isFocus()) {
			holder3.title.setText(bean.getTitle());
			this.loadImage(bean.getListPic(), holder3.image,
					this.getDefaultBitmap());
		} else {
			switch (type) {
			case Constant.news_normal:
				holder1.description.setText(bean.getDescription());
				holder1.commentNum.setText("评论:" + bean.getCommentNum());
				holder1.title.setText(bean.getTitle());

				this.loadImage(bean.getListPic(), holder1.iamge,
						this.getDefaultBitmap());
				break;

			case Constant.news_pics:
				String urls[] = CommonUtil.splitArray(bean.getUrls());
				holder2.pics.setText("组图" + bean.getImageNum());
				holder2.commentNum.setText("评论:" + bean.getCommentNum());
				holder2.title.setText(bean.getTitle());
				this.loadImage(urls[0], holder2.pics1, this.getDefaultBitmap());
				this.loadImage(urls[1], holder2.pics2, this.getDefaultBitmap());
				this.loadImage(urls[1], holder2.pics3, this.getDefaultBitmap());
				break;

			}

		}

		return convertView;
	}

	private static class ViewHolderType1 {
		private ImageView iamge;
		private TextView description;
		private TextView commentNum;
		private TextView title;

	}

	private static class ViewHolderType2 {
		private ImageView pics1;
		private ImageView pics2;
		private ImageView pics3;

		private TextView pics;
		private TextView commentNum;
		private TextView title;
	}

	private static class ViewHolderType3 {
		private ImageView image;
		private TextView title;
	}

}
