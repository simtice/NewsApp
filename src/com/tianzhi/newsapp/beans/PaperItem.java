/**
 * Copyright 2012 Lipengcheng
 */

package com.tianzhi.newsapp.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

// 取新闻列表方法：
// http://api.k.sohu.com/api/paper/term.go?paperId=107&termId=74634
// 根据本表的报刊ID和期ID取得该期新闻列表
// 新闻列表为HTML格式，链接分别有两种形式：
// 1、photo://termId=71988&newsId=8466116，根据期号与新闻ID取图片新闻
// 2、news://termId=71988&newsId=8454044，根据期号与新闻ID取普通新闻


/**
 * 
 * @author lpc
 * 报刊类
 */

@DatabaseTable(tableName="PaperItems")
public class PaperItem extends BaseRowEntity{
	private static final long serialVersionUID = 4530337347614809173L;
	
	@DatabaseField(id=true)
	private long paperId;  // 报刊ID
	@DatabaseField
	private String name;  // 报刊名称
	@DatabaseField
	private String icon1;  // 报刊图标1，订阅列表显示用	
	@DatabaseField
	private String icon2;  // 报刊图标2，新闻列表log	
	@DatabaseField
	private int paperType; // 报刊类型（默认为0）  
	@DatabaseField
	private String description;  // 报刊简介
	@DatabaseField
	private long lastestTermId;  // 最新一期ID
	@DatabaseField
	private long pubTime;  // 发布时间	
	@DatabaseField
	private long toTopTime;  // 置顶时间
	@DatabaseField
	private boolean isTop;  // 是否置顶
	@DatabaseField
	private boolean isRead;  // 是否已读
	@DatabaseField
	private long displayOrder; // 1 * 10000000000000 + toTopTime  或者  pubTime
	@DatabaseField
	private long modTime;  // 修改时间
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPaperType() {
		return paperType;
	}

	public void setPaperType(int paperType) {
		this.paperType = paperType;
	}


	public long getLastestTermId() {
		return lastestTermId;
	}

	public void setLastestTermId(long lastestTermId) {
		this.lastestTermId = lastestTermId;
	}

	public long getPubTime() {
		return pubTime;
	}

	public void setPubTime(long pubTime) {
		this.pubTime = pubTime;
	}

	public long getToTopTime() {
		return toTopTime;
	}

	public void setToTopTime(long toTopTime) {
		this.toTopTime = toTopTime;
	}

	public boolean isTop() {
		return isTop;
	}

	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public long getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		this.displayOrder = displayOrder;
	}

	public long getModTime() {
		return modTime;
	}

	public void setModTime(long modTime) {
		this.modTime = modTime;
	}

	public PaperItem() {
    }

	public long getPaperId() {
		return paperId;
	}

	public void setPaperId(long paperId) {
		this.paperId = paperId;
	}

	public String getIcon1() {
		return icon1;
	}

	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}

	public String getIcon2() {
		return icon2;
	}

	public void setIcon2(String icon2) {
		this.icon2 = icon2;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
