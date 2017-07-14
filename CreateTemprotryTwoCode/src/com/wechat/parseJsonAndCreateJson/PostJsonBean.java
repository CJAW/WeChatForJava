package com.wechat.parseJsonAndCreateJson;

import java.util.Map;

/**
 * 创建临时二维码的参数
 * @author user
 *
 */
public class PostJsonBean {

	//设置二维码的时间
	private int expire_seconds;
	//设置二维码的类型,临时：QR_SCENE；永久为：QR_LIMIT_STR_SCENE
	private String action_name;
	//设置二维码的详细信息
	private Map<String ,Map<String,String>> action_info;
	
	
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public Map<String, Map<String, String>> getAction_info() {
		return action_info;
	}
	public void setAction_info(Map<String, Map<String, String>> action_info) {
		this.action_info = action_info;
	}
	
	
	
	
	
}
