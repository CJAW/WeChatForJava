package com.wechat.downloadMedia;

import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;

/**
 * 下载多媒体文件
 * @author user
 *
 */

public class DownMedia {
 
	public static String downloadMedia(String appid,String secret,String Media_id,String savePath){
		
		String access_token = GetAccess_Token.getAccess_token(appid, secret);
		
		String Url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token="+access_token+"&media_id="+Media_id;
		
		String result = HttpsConUtil.httpsDownLoadMedia(savePath, Url, "GET");
		
		return result;
	}
	
	public static void main(String[] args){
		
		System.out.println(downloadMedia("wx49c33646098c2538", "2c2326d4bff07f42ef323259f258ca9d", "ImjwIBCswYHJaFWHQe8-psuOdO3tcqcLiZ0GuPZDrhDu4PUNw_pfTlbFrTnNnBi8", "/Users/user/Desktop/PHP/"));
	}
}
