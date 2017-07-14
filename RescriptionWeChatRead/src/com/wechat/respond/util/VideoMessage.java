package com.wechat.respond.util;

/**
 * 开发者服务器向用户发送视频文件
 * @author user
 *
 */
public class VideoMessage extends BaseMessage{

	//视屏
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}
	
	
}
