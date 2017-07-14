package com.wechat.getOpenID;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Url;

import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.jsonBean.GetOpenIDJsonBean;
import com.wechat.parseJson.ParseJson;

/**
 * 获取用户的openID
 * @author user
 *
 */

public class GetOpenID {
     
     
	public static String getOpenID(String appid,String secret,String next_openID){
		
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		
		String result= null;
	  
		
		if(next_openID ==null){
			String  Url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token+"&next_openid=";
		    result = HttpsConUtil.httpConUtil(Url, "GET", "UTF-8");
		    
		}else {
			String  Url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token+"&next_openid="+next_openID;
			result = HttpsConUtil.httpConUtil(Url, "GET", "UTF-8");
			    
		}
	
		
		return result;
	}
	
	
	public static void main(String[] args){
		GetOpenIDJsonBean getOpenIDJsonBean = ParseJson.parseJson(getOpenID("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d", null));
		System.out.println(getOpenIDJsonBean.getData().get("openid").get(0));
		List<String> list  = getOpenIDJsonBean.getData().get("openid");
		System.out.println(list.get(0));
	}
}
