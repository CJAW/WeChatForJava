package com.wechat.https;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * 获取用户的信息
 * @author user
 *
 */
public class GetUesrInformation {
	
	public static UserInformationBean getUserInformation(String access_token,String oppenid,String lang){
		
		String Url ="https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+oppenid+"&lang="+lang;
		
		String result = HttpsConUtil.getAccess_Token(Url, "GET",null);
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		UserInformationBean userInformationBean = gson.fromJson(result.toString(),UserInformationBean.class);
		
		
		return userInformationBean;
		
	}
	

}
