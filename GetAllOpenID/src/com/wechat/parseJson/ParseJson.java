package com.wechat.parseJson;

import com.google.gson.Gson;
import com.wechat.jsonBean.GetOpenIDJsonBean;

/**
 * 解析惊悚数据
 * @author user
 *
 */

public class ParseJson {

	public static GetOpenIDJsonBean parseJson(String jsomessage){

		
		Gson gson = new Gson();
		
		return gson.fromJson(jsomessage, GetOpenIDJsonBean.class);
		
	}
	
}
