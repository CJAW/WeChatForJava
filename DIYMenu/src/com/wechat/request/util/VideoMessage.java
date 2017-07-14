package com.wechat.request.util;

/**
 * 向开发者服务器发送视频文件
 * @author user
 *
 */
public class VideoMessage {

	//视频媒体id，可以调用接口下载数据
	private String MediaID;
	//视频缩略图的媒体ID，可以调用接口下载数据
	private String ThumbMediaID;
	
	
	public String getMediaID() {
		return MediaID;
	}
	public void setMediaID(String mediaID) {
		MediaID = mediaID;
	}
	public String getThumbMediaID() {
		return ThumbMediaID;
	}
	public void setThumbMediaID(String thumbMediaID) {
		ThumbMediaID = thumbMediaID;
	}
	
	
}
