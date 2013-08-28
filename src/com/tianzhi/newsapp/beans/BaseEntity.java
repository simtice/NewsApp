package com.tianzhi.newsapp.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * 实体基类
 * @author hlj
 * @version
 * @date 2012-12-07
 *
 */
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static SimpleDateFormat SDF_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 状态码
	 */
	private int statusCode;
	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
