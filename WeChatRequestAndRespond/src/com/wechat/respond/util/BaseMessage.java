package com.wechat.respond.util;

/**
 * 开发者服务器发送数据到用户
 * @author user
 *
 */
public class BaseMessage {

	   //用户的帐号
		private String TOUserName;
		//开发者的帐号
		private String FromUserName;
		//消息创建的时间
		private long CreateTime;
		//消息的类型
		private String MsgType;
		
		
		
		public String getTOUserName() {
			return TOUserName;
		}
		public void setTOUserName(String tOUserName) {
			TOUserName = tOUserName;
		}
		public String getFromUderName() {
			return FromUserName;
		}
		public void setFromUderName(String fromUderName) {
			FromUserName = fromUderName;
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
