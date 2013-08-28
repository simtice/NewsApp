package com.tianzhi.newsapp.util;

public class FileManager {

	
	
	public static String getSaveFilePath(boolean isThumb,String dirName) {
		if (CommonUtil.hasSDCard()) {
			if (isThumb) {
				return CommonUtil.getRootFilePath() + dirName + "/thumbnails/";
			}
			return CommonUtil.getRootFilePath() + dirName + "/files/";
		} else {
			if (isThumb) {
				return CommonUtil.getRootFilePath() + dirName + "/thumbnails/";
			}
			return CommonUtil.getRootFilePath() + dirName + "/files/";
		}
	}
	
	public static String getCacheRootDir(String dirName){
		if (CommonUtil.hasSDCard()) {
			return CommonUtil.getRootFilePath() + dirName + "/";
		} else {
			return CommonUtil.getRootFilePath() + dirName + "/";
		}
	}
}
