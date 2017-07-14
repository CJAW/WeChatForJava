package com.wechat.https;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * 获取授权的access_token
 */

public class GetAccess_Token {

	public static Access_TokenBean getAccess_token(String code) {
		String appid = "wx49c33646098c2538";
		String secret = "2c2326d4bff07f42ef323259f258ca9d";
		// 获取accesstoken的URL
		String AccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code ";
			

		String resutl = HttpsConUtil.getAccess_Token(AccessTokenUrl, "GET",null);

		
			// 解析json使用 Gson
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		Access_TokenBean access_TokenBean = gson.fromJson(resutl.toString(), Access_TokenBean.class);
		
		
		

		return access_TokenBean;
	}
	

}
