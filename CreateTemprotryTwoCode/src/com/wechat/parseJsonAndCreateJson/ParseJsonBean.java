package com.wechat.parseJsonAndCreateJson;

/**
 * 对返回的二维码数据进行解析
 * @author user
 *
 */
public class ParseJsonBean {

	//换取二维码的ticket
	private String ticket;
	//二维码的有效时间
	private int wxpire_seconds;
	//二维码的图片的地址
	private String url;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getWxpire_seconds() {
		return wxpire_seconds;
	}
	public void setWxpire_seconds(int wxpire_seconds) {
		this.wxpire_seconds = wxpire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
