package com.wechat.respond.util;



/**
 * 音乐类
 * @author user
 *
 */
public class Music {

	//标题
	private String Title;
	//描述
	private String Description;
	//音乐连接
	private String MusicUrl;
	//高品质的音乐连接，在Wi-Fi条件下优先播放
	private String HQMusicUrl;
	//缩略图的ID，通过上传文件后得到的ID
	private String ThumbMediaID;
	
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	public String getThumbMediaID() {
		return ThumbMediaID;
	}
	public void setThumbMediaID(String thumbMediaID) {
		ThumbMediaID = thumbMediaID;
	}
	
	
	
	
}
