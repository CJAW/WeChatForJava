package com.wechat.createTwoCode;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.parseJsonAndCreateJson.PostJsonBean;

/**
 * 创建临时二维码
 * @author user
 *
 */
public class CreateTwoCode {

	public static String createCode() {

		String appid = "wx49c33646098c2538";
		String secret = "2c2326d4bff07f42ef323259f258ca9d";
		
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		// 设置二维码参数的url
		String Url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+access_token;

		// 创建二维码的参数
		PostJsonBean postJsonBean = new PostJsonBean();
		postJsonBean.setAction_name("QR_SCENE");
		postJsonBean.setExpire_seconds(110000);
		Map<String, String> scene = new HashMap<String, String>();
		scene.put("scene_id", "123");
		Map<String, Map<String, String>> action_info = new HashMap<String, Map<String, String>>();
		action_info.put("scene", scene);
		postJsonBean.setAction_info(action_info);
		

		//将数据转化为json
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		

		String message =gson.toJson(postJsonBean, postJsonBean.getClass());

		String result = HttpsConUtil.request(message, Url, "POST","UTF-8");

		return result;

	}

}
