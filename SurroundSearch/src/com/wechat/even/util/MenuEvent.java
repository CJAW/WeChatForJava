package com.wechat.even.util;

/**
 * 向开发者服务器发送自定义菜单的单击按钮的事件
 * 
 * 当点击view（url的跳转）类型的菜单按钮时不会向开发者服务器推送事件
 * @author user
 *
 */
public class MenuEvent {

	//事件key的值与自定义菜单中的key值对应，用来判断用户单击的是哪一个事件
	private String EventKey;
	
	public String getEventKey(){
		return EventKey;
	}
	
	public void setEventKey(String EventKey){
		
		this.EventKey = EventKey;
	}
}
