/**
 * Copyright 2012 Lipengcheng
 */

package com.tianzhi.newsapp.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 * @author lpc
 * 栏目
 */


@DatabaseTable(tableName="Channels")
public class Channel extends BaseRowEntity{
	private static final long serialVersionUID = -6180663497501824948L;
	
	@DatabaseField(id=true)
	private long channelId;  // 栏目ID
	@DatabaseField
	private long parentId;  // 父栏目ID
	@DatabaseField
	private String channelName;  // 栏目名称
	@DatabaseField
	private int channelType; // 栏目类型 0：新闻，1：组图  
	@DatabaseField
	private int displayOrder; // 栏目显示顺序，可显示栏目此值>=0,不可显示栏目此值为-1
	@DatabaseField
	private long modTime;  // 修改时间
	


	public int getChannelType() {
		return channelType;
	}

	public void setChannelType(int channelType) {
		this.channelType = channelType;
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public long getModTime() {
		return modTime;
	}

	public void setModTime(long modTime) {
		this.modTime = modTime;
	}

	public Channel() {
    }

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
}
