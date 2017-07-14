package com.wechat.parseAndCreateJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wechat.jsonBean.CreateGroupsSuccess;
import com.wechat.jsonBean.HttpsResultBean;
import com.wechat.jsonBean.SelectGroups;

public class ParseJson {

	/**
	 * 解析查询的json数据
	 * @param message
	 * @return
	 */
	public static SelectGroups parseSelectJsonBean(String message){
		
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		
		SelectGroups result =  gson.fromJson(message,SelectGroups.class); 
		
		return result;
		
		
	}
	
	/**
	 * 解析创建组的json数据
	 * @param message
	 * @return
	 */
	public static CreateGroupsSuccess parseCreateGroupsBean(String message){
		
		Gson gson = new Gson();
		
		CreateGroupsSuccess result =  gson.fromJson(message,CreateGroupsSuccess.class); 
		
		return result;
		
	}
	
	/**
	 * 解析请求的结果json
	 * 
	 * @param message
	 * @return
	 */
	public static HttpsResultBean parseResult(String message) {

		Gson gson = new Gson();

		HttpsResultBean result = gson.fromJson(message, HttpsResultBean.class);

		return result;

	}
	
	
}
