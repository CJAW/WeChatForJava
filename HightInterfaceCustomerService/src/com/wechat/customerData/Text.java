package com.wechat.customerData;


import java.util.Map;

/**
 * 客服的文本类容
 * @author user
 *
 */
public class Text extends DataBase{
	

	private Map<String,String> text;

	public Map<String, String> getText() {
		return text;
	}

	public void setText(Map<String, String> text) {
		this.text = text;
	}
	
	
	

}
