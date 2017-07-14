package com.wechat.respond.util;

/**
 * 开发者服务器向用户发送图片信息
 * 图片信息预先上传到微信的服务器端，用户通过ID进行下载
 * @author user
 *
 */

public class ImageMessage extends BaseMessage{

	//图片
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
	
	
}
