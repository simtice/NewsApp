package com.tianzhi.newsapp.util;

import java.io.File;

public class FileCache{
	private boolean isThumb;//是否保存为缩略图
	private String dirName;//缓存根目录名

	public FileCache(String dirName) {
		this.dirName = dirName;
	}
	
	public void creatCacheDir(boolean isThumb){
		this.isThumb = isThumb;
		FileHelper.createDirectory(getCacheDir());
	}

	public File getFile(String url) {
		File f = new File(getSavePath(url));
		return f;
	}
	
	public String getSavePath(String url) {
		String filename = String.valueOf(url.hashCode());
		return getCacheDir() + filename;
	}

	public String getCacheDir() {
		return FileManager.getSaveFilePath(isThumb,this.dirName);
	}

	public void clear(String dirName) {
		FileHelper.deleteDirectory(FileManager.getCacheRootDir(dirName));
	}
	
	public boolean isCacheDirExis() {
		// TODO Auto-generated method stub
		File file = new File(getCacheDir());
		if (file.exists()) {
			return true;
		}

		return false;
	}

}
