package com.wechat.alterGroupsName;

/**
 * 修改组的名字
 */

import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.jsonBean.AlterGroupsName;
import com.wechat.jsonBean.AlterGroupsNameBean;
import com.wechat.jsonBean.HttpsResultBean;
import com.wechat.parseAndCreateJson.CreatePostJson;
import com.wechat.parseAndCreateJson.ParseJson;

public class AlterGroupName {

	public static String alterGroupName(String appid,String secret){
		
		String acess_token = GetAccess_Token.getAccess_token(appid, secret);
		
		String Url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token="+acess_token;
		//创建数据
		AlterGroupsNameBean alterGroupsNameBean = new AlterGroupsNameBean();
		alterGroupsNameBean.setId(167);
		alterGroupsNameBean.setName("dawda");
		
		AlterGroupsName alterGroupsName = new AlterGroupsName();
		alterGroupsName.setGroup(alterGroupsNameBean);
		
		String JsonMessage = CreatePostJson.alterGroupsName(alterGroupsName);
		
		String result = HttpsConUtil.request(JsonMessage, Url,"POST", "UTF-8");
		
		//解析结果
		HttpsResultBean Message = ParseJson.parseResult(result);
		
		String r_m = null;
		
		if(Message.getErrcode()==0){
			r_m = "成功";
		}else{
			r_m = Message.getErrcode()+"  "+Message.getErrmsg();
		}
		
		return r_m;
		
	}
	
//	public static void main(String[] args){
//		
//		System.out.println(alterGroupName("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d"));
//	}
	
	
}
