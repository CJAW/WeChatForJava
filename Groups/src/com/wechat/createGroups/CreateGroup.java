package com.wechat.createGroups;

/**
 * 创建分组
 */

import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.jsonBean.CreateGroups;
import com.wechat.jsonBean.CreateGroupsJsonBean;
import com.wechat.jsonBean.CreateGroupsSuccess;
import com.wechat.parseAndCreateJson.CreatePostJson;
import com.wechat.parseAndCreateJson.ParseJson;


public class CreateGroup {

	public static String  createGroup(String appid,String secret){
		
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		
		String Url =" https://api.weixin.qq.com/cgi-bin/groups/create?access_token="+access_token;
		
		//创建json数据
		CreateGroupsJsonBean createGroupsJsonBean = new CreateGroupsJsonBean();
		createGroupsJsonBean.setName("aadd");
		
		CreateGroups createGroups = new CreateGroups();
		createGroups.setGroup(createGroupsJsonBean);
		
		String postMessage = CreatePostJson.createGroupsJson(createGroups);
		
		
		String reslut = HttpsConUtil.request(postMessage, Url, "POST", "UTF-8");
		
		return reslut;
		
	}
	
	
//	public static void main(String[] args){
//		
//		
//		CreateGroupsSuccess createSuccessBean = ParseJson.parseCreateGroupsBean(createGroup("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d"));
//		System.out.println(createSuccessBean.getGroup().getName());
//		System.out.println(createSuccessBean.getGroup().getId());
//	}
	
}
