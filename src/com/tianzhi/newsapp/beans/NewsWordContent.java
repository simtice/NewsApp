package com.tianzhi.newsapp.beans;

import java.util.ArrayList;

/**
 * 
 * @author lpc
 * 文字型新闻内容类
 */
public class NewsWordContent extends NewsContent {
	private String content;  // 新闻内容
	private ArrayList<String> images;  // 新闻内容包含的图片列表

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
}
