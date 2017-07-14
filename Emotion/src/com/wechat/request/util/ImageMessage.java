package com.wechat.request.util;

/**
 * 向开发者服务器发送图片信息，保存在微信服务器上，开发者服务器通过url读取图片
 * @author user
 *
 */

public class ImageMessage extends BaseMessage{

	//服务器通过url获取微信服务器上的图片
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	
	
}
