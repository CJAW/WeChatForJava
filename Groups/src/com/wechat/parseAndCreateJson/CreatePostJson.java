package com.wechat.parseAndCreateJson;

import com.google.gson.Gson;
import com.wechat.jsonBean.AlterGroupsName;
import com.wechat.jsonBean.CreateGroups;
import com.wechat.jsonBean.MoveGroupsBean;




/**
 * 对要发送的数据包装成json格式
 * @author user
 *
 */
public class CreatePostJson {

	/**
	 * 创建分组的json
	 * @param createGroup
	 * @return
	 */
	public static String createGroupsJson(CreateGroups createGroup){
		
		Gson gson = new Gson();
		
		return gson.toJson(createGroup, createGroup.getClass());
		
	}
	
	
	/**
	 * 更改分组名的json
	 * @param createGroup
	 * @return
	 */
	public static String alterGroupsName(AlterGroupsName alterGroupsName){
		
		Gson gson = new Gson();
		
		return gson.toJson(alterGroupsName, alterGroupsName.getClass());
		
	}
	
	/**
	 * 移动用户到指定的分组名的json
	 * @param createGroup
	 * @return
	 */
	public static String moveGroup(MoveGroupsBean moveGroupsBean){
		
		Gson gson = new Gson();
		
		return gson.toJson(moveGroupsBean, moveGroupsBean.getClass());
		
	}
	
	
	
}
