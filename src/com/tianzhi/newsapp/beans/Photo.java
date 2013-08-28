package com.tianzhi.newsapp.beans;

/**
 * 
 * @author lpc
 * 组图用的图片类
 */
public class Photo {
	private String picUrl;  // 图片地址 如：http://cache.k.sohu.com/img7/adapt/wb/2013/06/03/2126259976_620_1000.jpg
	private String title;  // 图片标题
	private String description;  // 图片摘要
	private String shareLink;  // 分享路径： http://3g.k.sohu.com/t/n8513255_1
	
	
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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
	public String getShareLink() {
		return shareLink;
	}
	public void setShareLink(String shareLink) {
		this.shareLink = shareLink;
	}
}
