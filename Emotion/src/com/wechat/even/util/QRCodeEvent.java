package com.wechat.even.util;

/**
 * 向开发者服务器发送用户扫描二维码的的信息
 * 如果用户未关注公众号则会发送不同的事件类型和key值
 * @author user
 *
 */
public class QRCodeEvent extends BaseEvent{
	
	//事件的key值
	private String EventKey;
	//换取二维码图片
	private String Ticket;
	
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	
	

	
	
	

}
