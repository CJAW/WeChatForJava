package com.wechat.request.util;

/**
 * 向开发者服务器发送地理位置
 * @author user
 *
 */
public class LocationMessage extends BaseMessage{

	//纬度
	private String Location_X;
	//经度
	private String Location_Y;
	//地图缩放大小
	private String Scale;
	//地理位置信息
	private String Lable;
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
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
