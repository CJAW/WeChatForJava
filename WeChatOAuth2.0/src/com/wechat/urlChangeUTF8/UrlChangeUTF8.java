package com.wechat.urlChangeUTF8;
/**
 * 通过发送地址链接或view菜单或news引导用户授权
 * 对回调的地址进行编码
 * 
 */
import java.io.UnsupportedEncodingException;

public class UrlChangeUTF8 {

	public static String changeEconding(String url){
		
		String result = null;
		
		try {
			result = java.net.URLEncoder.encode(url,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args){
		System.out.println(changeEconding("http://115.28.201.53/WeChatOAuth2.0/WeChatServlet"));
		
	}
	
	//要发送的地址链接，使用文本或view菜单或图文news
	//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx49c33646098c2538&redirect_uri=115.28.201.53%2FWeChatOAuth2.0%2FOAuthServlet&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect 
	
	
}
