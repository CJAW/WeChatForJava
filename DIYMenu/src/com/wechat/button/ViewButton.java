package com.wechat.button;


/**
 * 视图的button，用于访问网页
 * @author user
 *
 */
public class ViewButton extends BaseButton{

	private String type;
	private String url;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
