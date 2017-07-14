package com.wechat.https;

import com.google.gson.Gson;

/**
 * 刷新网页的授权
 * @author user
 *
 */
public class RefreshAccess_Token {

	public static Access_TokenBean refresh_AccessToken(String refresh_token){
		
		
		String appid = "wx49c33646098c2538";
		String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+appid+"&grant_type=refresh_token&refresh_token="+refresh_token;
		
		String result = HttpsConUtil.getAccess_Token(url, "GET", "UTF-8");
		
		Gson gson = new Gson();
		
		Access_TokenBean access_TokenBean = gson.fromJson(result,Access_TokenBean.class);
		
		return access_TokenBean;
		
		
		
	}
	
	
}
