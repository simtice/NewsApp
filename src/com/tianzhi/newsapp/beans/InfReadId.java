/**
 * Copyright 2009 Joe LaPenna
 */

package com.tianzhi.newsapp.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author lpc
 * 已读新闻ID
 */

@DatabaseTable(tableName="infReadIds")
public class InfReadId {
	@DatabaseField(id=true)
	private long newsId;
	private long readTime;
	
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	public long getReadTime() {
		return readTime;
	}
	public void setReadTime(long readTime) {
		this.readTime = readTime;
	}


}
