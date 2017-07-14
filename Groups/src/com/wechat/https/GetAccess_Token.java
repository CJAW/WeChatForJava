package com.wechat.https;

import com.google.gson.Gson;

/**
 * 获取access_token
 */

public class GetAccess_Token {

	public static String getAccess_token(String appid,String secret  ) {
		
		
		// 获取accesstoken的URL
		String AccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid
				+ "&secret=" + secret;

		String resutl = HttpsConUtil.httpConUtil(AccessTokenUrl, "GET", "UTF-8");
		
		
		// 解析json使用 Gson
		Gson gson = new Gson();
		Access_TokenBean access_TokenBean = gson.fromJson(resutl.toString(), Access_TokenBean.class);
		String access_token = access_TokenBean.getAccess_token();

		return access_token;
	}

}
