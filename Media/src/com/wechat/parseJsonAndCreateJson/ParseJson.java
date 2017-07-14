package com.wechat.parseJsonAndCreateJson;

import com.google.gson.Gson;
import com.wechat.JsonBean.MediaReturnBean;

/**
 *解析json 
 * @author user
 *
 */

public class ParseJson {

	public static MediaReturnBean parseMediaReturn(String message){
		Gson  gson = new Gson();
		
		return gson.fromJson(message, MediaReturnBean.class);
	}
	
}
