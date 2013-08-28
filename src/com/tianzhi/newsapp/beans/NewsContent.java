package com.tianzhi.newsapp.beans;

/**
 * 
 * @author lpc
 * 新闻内容基类
 */
public class NewsContent{
	private long newsId;  // 新闻ID
	private String title;  // 新闻标题
	private long pubTime;  // 发布时间
	private String from;  // 新闻来源
	private int commentNum;  // 评论数
	private String shareContent;  // 分享内容  <![CDATA[#搜狐早报#习近平:加勒比地区从未离开我视野"这是我就任国家主席后的首访，但加勒比从未离开过我视野。".... http://3g.k.sohu.com/t/n8508687 @搜狐新闻客户端]]>
	private String link;  // 访问链接  http://3g.k.sohu.com/t/n8508687
	private String nextNewsLink;  // 下一条新闻样式有两种 1、news://期号_新闻ID,如 news://74634_8505840； 2、photo://期号_新闻ID，如photo://74634_8509633 
	private String preNewsLink;  // 下一条新闻样式有两种 1、news://期号_新闻ID,如 news://74634_8505840； 2、photo://期号_新闻ID，如photo://74634_8509633
	
	
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getShareContent() {
		return shareContent;
	}
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getNextNewsLink() {
		return nextNewsLink;
	}
	public void setNextNewsLink(String nextNewsLink) {
		this.nextNewsLink = nextNewsLink;
	}
	public String getPreNewsLink() {
		return preNewsLink;
	}
	public void setPreNewsLink(String preNewsLink) {
		this.preNewsLink = preNewsLink;
	}
	
}