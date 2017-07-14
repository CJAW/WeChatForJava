package com.wechat.sendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;
import com.wechat.Json.CreateJson;
import com.wechat.customerData.Article;
import com.wechat.customerData.Text;
import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.https.ResultBean;

/**
 * 将客服数据消息发送到指定的公众号
 * @author user
 *
 */
public class SendCustomerMessage {

	public static void sendMessage() {
		//调用客服接口
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
				+ GetAccess_Token.getAccess_token();

		// 转化成json格式
		String JsonMessage = CreateJson.makeTextToJson("o2_CwwpWhHol8N30Vzq9KhdU3yxM",
				"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx49c33646098c2538&redirect_uri=http%3A%2F%2F115.28.201.53%2FWeChatOAuth2.0%2FWeChatServlet&response_type=code&scope=snsapi_userinfo&state=12345#wechat_redirect ");
//		String JsonMessage = CreateJson.makeImageToJson("o2_CwwpWhHol8N30Vzq9KhdU3yxM","1111");
//		String JsonMessage = CreateJson.makeVoiceToJson("o2_CwwpWhHol8N30Vzq9KhdU3yxM","1111");
//		String JsonMessage = CreateJson.makeVideoToJson("o2_CwwpWhHol8N30Vzq9KhdU3yxM","1111","dawad");
//		String JsonMessage = CreateJson.makeMusicToJson("o2_CwwpWhHol8N30Vzq9KhdU3yxM","1111","das","das","dada","asssa");
		
//		Article article = new Article();
//		article.setDescription("dasda");
//		article.setPicUrl("ada");
//		article.setTitle("adsa");
//		article.setUrl("adas");
//		
//		Article article1 = new Article();
//		article1.setDescription("dasda");
//		article1.setPicUrl("ada");
//		article1.setTitle("adsa");
//		article1.setUrl("adas");
//		
//		List<Article> list = new ArrayList<Article>();
//		list.add(article);
//		list.add(article1);
//		
//		String JsonMessage = CreateJson.makeNewsToJson("o2_CwwpWhHol8N30Vzq9KhdU3yxM", list);
//		
//		
		
        //发送
		String result = HttpsConUtil.request(JsonMessage, url, "POST", "UTF-8");
		//放回结果
		Gson gson = new Gson();
		ResultBean l_r = gson.fromJson(result,ResultBean.class);
		
		System.out.println(JsonMessage);
		
		System.out.println(result);
		
		if(l_r.getErrcode()==0){
			System.out.println("ok");
		}else {
			System.out.println("false");
		}
	}
	
	public static void main(String[] args){
		sendMessage();
	}
}
