package com.wechat.respond.util;

/**
 * 开发者服务器发送数据到用户
 * @author user
 *
 */
public class BaseMessage {

	   //用户的帐号
		private String ToUserName;
		//开发者的帐号
		private String FromUserName;
		//消息创建的时间
		private long CreateTime;
		//消息的类型
		private String MsgType;
		
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
		
		
		
	
}
