package com.wechat.respond.util;

/**
 * 视屏类
 * @author user
 *
 */
public class Video {

	   //视频媒体id，上传文件后得到
		private String MediaID;
		//视频缩略图的媒体ID，上传文件后得到
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
