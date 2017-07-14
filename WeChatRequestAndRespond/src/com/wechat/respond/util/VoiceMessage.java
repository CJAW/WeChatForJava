package com.wechat.respond.util;

/**
 * 开发者服务器向用户发送语音
 * @author user
 *
 */
public class VoiceMessage extends BaseMessage{
	
	//语音
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	
	

}
