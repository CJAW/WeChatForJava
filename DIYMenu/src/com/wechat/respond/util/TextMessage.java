package com.wechat.respond.util;

/**
 * 开发者服务器发送的文本到用户
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
