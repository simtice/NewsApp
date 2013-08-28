package com.tianzhi.newsapp.beans;

import java.util.ArrayList;

/**
 * 
 * @author lpc
 * 图片型新闻内容类
 */
public class NewsPicContent extends NewsContent{
	
	private long groupId;  // 组ID
	private ArrayList<Photo> gallery; // 图片URL列表

	public ArrayList<Photo> getGallery() {
		return gallery;
	}

	public void setGallery(ArrayList<Photo> gallery) {
		this.gallery = gallery;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
}