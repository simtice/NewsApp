package com.tianzhi.newsapp.beans;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 * @author lpc
 * 新闻列表项
 */

@DatabaseTable(tableName="NewsListItems")
public class NewsListItem extends BaseRowEntity{
	private static final long serialVersionUID = 8576294793237071162L;
	
	@DatabaseField(id=true)
	private long newsId;  // 新闻ID
	@DatabaseField
	private long channelId;  // 栏目ID
	@DatabaseField
	private int newsType;  // 新闻类型 1：普通图文环绕新闻；2：图片新闻；3：专题新闻；4：视频新闻；5：直播新闻
	@DatabaseField
	private String title;  // 新闻标题
	@DatabaseField
	private String description;  // 新闻摘要
	@DatabaseField
	private boolean isFocus;  // 是否是焦点新闻，焦点新闻显示在窗口顶部
	@DatabaseField
	private int commentNum;  // 评论数
	@DatabaseField
	private String listPic;  // 列表图片url
	@DatabaseField
	private long pubTime;  // 发布时间
	@DatabaseField
	private String from;  // 新闻来源
	@DatabaseField
	private long modTime;  // 修改时间	
	@DatabaseField 
	private String urls;
	@DatabaseField
	private int imageNum;
	
	
	public int getImageNum() {
		return imageNum;
	}
	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	public int getNewsType() {
		return newsType;
	}
	public void setNewsType(int newsType) {
		this.newsType = newsType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isFocus() {
		return isFocus;
	}
	public void setFocus(boolean isFocus) {
		this.isFocus = isFocus;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getListPic() {
		return listPic;
	}
	public void setListPic(String listPic) {
		this.listPic = listPic;
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

	
}