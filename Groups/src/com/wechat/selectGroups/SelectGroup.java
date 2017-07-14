package com.wechat.selectGroups;

import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.jsonBean.SelectGroups;
import com.wechat.parseAndCreateJson.ParseJson;

/**
 * 查询分组
 * @author user
 *
 */

public class SelectGroup {

	public static String selectGroups(String appid,String secret){
		
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		
		String Url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token="+access_token;
		
		String result = HttpsConUtil.httpConUtil(Url, "GET", "UTF-8");
		
		return result;
		
	}
	
//	public static void main(String[] args){
//		
//		
//		SelectGroups selectGroups = ParseJson.parseSelectJsonBean(selectGroups("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d"));
//		
//		for(int i =0; i<selectGroups.getGroups().size();i++){
//			System.out.println(selectGroups.getGroups().get(i).getName());
//			
//		}
//		
//		
//	}
	
}
