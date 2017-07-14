package com.wechat.request.util;


/**
 * 对微信XML的数据的响应或请求或事件的基本属性
 * @author user
 *
 */
public class BaseMessage {

	//开发者的帐号
	private String ToUserName;
	//发送者的帐号
	private String FromUserName;
	//消息创建的时间
	private long CreateTime;
	//消息的类型
	private String MsgType;
	//id号
	private long MsgID;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
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
	public long getMsgID() {
		return MsgID;
	}
	public void setMsgID(long msgID) {
		MsgID = msgID;
	}
	
	

	
	
	
	
}
