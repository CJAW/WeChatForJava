package com.wechat.request.util;

/**
 * 向开发者服务器发送语音
 * @author user
 *
 */
public class VoiceMessage extends BaseMessage{
	
	//媒体id,可以使用该ID调用接口下载数据
	private String MediaId;
	//语音格式
	private String Format;
	//语音识别结果
	private String Recognition;
	
	
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
	
	

}
