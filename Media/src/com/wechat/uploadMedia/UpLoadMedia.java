package com.wechat.uploadMedia;

import com.wechat.JsonBean.MediaReturnBean;
import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.parseJsonAndCreateJson.ParseJson;

/**
 * 
 * @author user
 *上传多媒体文件
 */

public class UpLoadMedia {

	public static String UploadMediaFile(String appid, String secret, String Type) {
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		String Url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=" + access_token + "&type=" + Type;
	
		//多媒体文件要放在开发者服务器上,路径要与填写的接口配置信息相同
		String mediaUrl = "http://115.28.201.53/WeChatOAuth2.0/Success/0.jpeg";
		String Result = HttpsConUtil.upLoadMedia(Url, mediaUrl, "POST", "UTF-8");
		return Result;

	}

//	public static void main(String[] args) {
//
//		MediaReturnBean mediaReturnBean = ParseJson.parseMediaReturn(UploadMediaFile("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d", "image"));
//		
//		System.out.println(mediaReturnBean.getMedia_id());
//
//	}

}
