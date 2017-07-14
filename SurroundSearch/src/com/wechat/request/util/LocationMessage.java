package com.wechat.request.util;

/**
 * 向开发者服务器发送地理位置
 * @author user
 *
 */
public class LocationMessage extends BaseMessage{

	//纬度
	private String Localtion_X;
	//经度
	private String Localtion_Y;
	//地图缩放大小
	private String Scale;
	//地理位置信息
	private String Lable;
	
	
	
	public String getLocaltion_X() {
		return Localtion_X;
	}
	public void setLocaltion_X(String localtion_X) {
		Localtion_X = localtion_X;
	}
	public String getLocaltion_Y() {
		return Localtion_Y;
	}
	public void setLocaltion_Y(String localtion_Y) {
		Localtion_Y = localtion_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLable() {
		return Lable;
	}
	public void setLable(String lable) {
		Lable = lable;
	}

	
	
	
}
