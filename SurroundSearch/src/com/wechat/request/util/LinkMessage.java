package com.wechat.request.util;
/**
 * 向开发者服务器发送连接
 * @author user
 *
 */
public class LinkMessage {

	
	//消息标题
	private String Title;
	//消息描述
	private String  Description;
	//消息连接
	private String Url;
	
	
	
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
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	
	
	
}
