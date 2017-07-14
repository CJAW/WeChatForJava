package com.wechat.even.util;

/**
 * 向开发者服务器发送事件的基本属性
 * @author user
 *
 */

public class BaseEvent {

	
	//开发者的帐号
	private String TOUserName;
	//发送者的帐号
	private String FromUderName;
	//消息创建的时间
	private long CreateTime;
	//消息的类型
	private String MsgType;
	//事件类型
	private String Event;
	
	
	public String getTOUserName() {
		return TOUserName;
	}
	public void setTOUserName(String tOUserName) {
		TOUserName = tOUserName;
	}
	public String getFromUderName() {
		return FromUderName;
	}
	public void setFromUderName(String fromUderName) {
		FromUderName = fromUderName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	
	
	
	
}
