package com.tianzhi.newsapp.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author lpc
 * 组图列表项
 */

@DatabaseTable(tableName="GroupPicListItems")
public class GroupPicListItem extends BaseRowEntity{
	private static final long serialVersionUID = 7148162954355950193L;
	
	@DatabaseField(id=true)
	private long groupId;  // 图片组ID
	@DatabaseField
	private long channelId;  // 栏目ID	
	@DatabaseField
	private String title;  // 图片组标题
	@DatabaseField
	private String listPic;  // 列表图片url
	@DatabaseField
	private int commentNum;  // 评论数
	@DatabaseField
	private int favoriteNum;  // 收藏数
	@DatabaseField
	private int imageNum;  // 图片数
	@DatabaseField
	private long pubTime;  // 发布时间
	@DatabaseField
	private String from;  // 图片来源
	@DatabaseField
	private long modTime;  // 修改时间	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getListPic() {
		return listPic;
	}
	public void setListPic(String listPic) {
		this.listPic = listPic;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getFavoriteNum() {
		return favoriteNum;
	}
	public void setFavoriteNum(int favoriteNum) {
		this.favoriteNum = favoriteNum;
	}
	public int getImageNum() {
		return imageNum;
	}
	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}
	public long getPubTime() {
		return pubTime;
	}
	public void setPubTime(long pubTime) {
		this.pubTime = pubTime;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public long getModTime() {
		return modTime;
	}
	public void setModTime(long modTime) {
		this.modTime = modTime;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

}