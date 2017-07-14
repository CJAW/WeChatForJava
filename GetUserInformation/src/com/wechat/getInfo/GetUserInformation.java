package com.wechat.getInfo;

import com.google.gson.Gson;
import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;


/**
 * 获取用户的信息
 * @author user
 *
 */
public class GetUserInformation {
	
	
	public static String getInformation(String appid,String secret,String openid){
		
		//获取access token
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		
		//调用接口
		String Url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+access_token+"&openid="+openid+"&lang=zh_CN"; 
		String result = HttpsConUtil.httpConUtil(Url,"GET", "UTF-8");
		
//		//获取json数据
//		Gson gson = new Gson();
//		
//		GetUserBean message = gson.fromJson(result,GetUserBean.class);
		
		return result;
		
	}
	
	
	public static void main(String[] args){
		
		System.out.println(getInformation("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d", "o2_CwwpWhHol8N30Vzq9KhdU3yxM"));
	}

}
