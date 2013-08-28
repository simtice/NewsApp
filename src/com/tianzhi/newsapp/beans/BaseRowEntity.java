package com.tianzhi.newsapp.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * 实体基类
 * @author lpc
 * @version
 * @date 2012-12-07
 *
 */
public class BaseRowEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3910284113031681318L;
	
	public final static SimpleDateFormat SDF_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
	private int operateType; //操作类型 0:增加 1：修改  2：删除
	public int getOperateType() {
		return operateType;
	}
	public void setOperateType(int operateType) {
		this.operateType = operateType;
	}
	
}
