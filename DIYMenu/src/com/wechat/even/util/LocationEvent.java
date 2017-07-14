package com.wechat.even.util;

/**
 * 向开发者服务器发送地理位置事件
 * 会提示用户是否开启
 * 
 * @author user
 *
 */
public class LocationEvent {

	//纬度
	private String Latitude;
	//经度
	private String Longitude;
	//位置描述
	private String Precision;
	
	
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}
	
	
	
}
