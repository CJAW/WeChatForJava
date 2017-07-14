package com.wechat.respond.util;
/**
 * 开发者服务器向用户发送音乐
 * @author user
 *
 */

public class MusicMessage extends BaseMessage{

	//音乐
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
	
}
