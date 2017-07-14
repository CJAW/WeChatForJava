package com.wechat.moveGroup;

import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.jsonBean.HttpsResultBean;
import com.wechat.jsonBean.MoveGroupsBean;
import com.wechat.jsonBean.SelectGroups;
import com.wechat.parseAndCreateJson.CreatePostJson;
import com.wechat.parseAndCreateJson.ParseJson;

/**
 * 
 * @author user
 *移动用户到指定的组
 */

public class MoveGroup {

	public static String moveGroup(String appid, String secret) {

		String access_token = GetAccess_Token.getAccess_token(appid, secret);

		String Url = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=" + access_token;

		//创建数据
		MoveGroupsBean moveGroupsBean = new MoveGroupsBean();
		moveGroupsBean.setOpenid("o2_CwwpWhHol8N30Vzq9KhdU3yxM");
		moveGroupsBean.setTo_groupid(167);
		;

		String JsonMessage = CreatePostJson.moveGroup(moveGroupsBean);

		String result = HttpsConUtil.request(JsonMessage, Url, "POST", "UTF-8");

		//解析结果
		HttpsResultBean Message = ParseJson.parseResult(result);

		String r_m = null;

		if (Message.getErrcode() == 0) {
			r_m = "成功";
		} else {
			r_m = Message.getErrcode() + "  " + Message.getErrmsg();
		}

		return r_m;
		
		
	}
	
//	public static void main(String[] args){
//		
//		
//		  System.out.println(moveGroup("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d"));
//		
//		
//		
//		
//	}
	
}
