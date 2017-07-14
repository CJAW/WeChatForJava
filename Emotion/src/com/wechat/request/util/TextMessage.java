package com.wechat.request.util;

/**
 * 向开发者服务器发送的文本
 */

public class TextMessage extends BaseMessage{
	
	//文本信息
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	

}
