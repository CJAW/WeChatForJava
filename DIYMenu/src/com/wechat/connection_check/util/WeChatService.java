package com.wechat.connection_check.util;
import java.io.UnsupportedEncodingException;
/**
 * 响应用户的亲求,以xml的格式返回
 * @author user
 *
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.wechat.parse_generat_xml.util.GeneratXml;
import com.wechat.parse_generat_xml.util.ParseXml;
import com.wechat.respond.util.Article;
import com.wechat.respond.util.NewsMessage;
import com.wechat.respond.util.TextMessage;



public class WeChatService {

	//请求文件类型
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";
	//亲求的事件消息类型
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";
	
	//事件文件类型
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	public static final String EVENT_TYPE_MENU = "CLICK";
	//扫描二维码的消息类型
	public static final String VENT_TYPE_QRCODE = "scan";
	//订阅的消息类型
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	//取消订阅的消息类型
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	
	
	//响应事件类型
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	public static final String RESP_MESSAGE_TYPE_EVENT = "event";
	
	
	
	public static String process(HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//解析用户请求的数据。判断消息的类型
		Map<String, String> message = ParseXml.parseXml(request);
		//判断消息的类型
		String msgType = message.get("MsgType"); 
		//开发者帐号
		String toUserName = message.get("ToUserName");
		//微信帐号
		String formUesrName = message.get("FromUserName");
		// 设置文本信息
		TextMessage textMessage = new TextMessage();
		
		//回复文本消息
		textMessage.setToUserName(formUesrName);
		textMessage.setFromUserName(toUserName);
		textMessage.setCreateTime(new Date().getTime());
		textMessage.setMsgType(RESP_MESSAGE_TYPE_TEXT);
		
		// 要回复的类容
		String respMessage = null;
		String respXML =null;
		
		if (msgType.equals(REQ_MESSAGE_TYPE_TEXT)) {

			respMessage = "请使用菜单!";
			textMessage.setContent(respMessage);
			//将文本类容转化为xml格式
			 respXML = GeneratXml.messageToXML(textMessage);
		}

		else if (msgType.equals(REQ_MESSAGE_TYPE_IMAGE)) {

			respMessage = "你输入的是图片消息";
		}

		else if (msgType.equals(REQ_MESSAGE_TYPE_LINK)) {

			respMessage = "你输入的是连接消息";
		}

		else if (msgType.equals(REQ_MESSAGE_TYPE_LOCATION)) {

			respMessage = "你输入的是位置消息";
		}

		else if (msgType.equals(REQ_MESSAGE_TYPE_VOICE)) {

			respMessage = "你输入的是语音消息";
		}

		else if (msgType.equals(REQ_MESSAGE_TYPE_VIDEO)) {

			respMessage = "你输入的是视屏消息";
		}
		
		
		
        //事件响应
		//获取消息类型
		else if (msgType.equals(REQ_MESSAGE_TYPE_EVENT)) {

			//获取事件类型
			String eventType = message.get("Event");

			if (eventType.equals(EVENT_TYPE_SUBSCRIBE)) {
				
				respMessage = "感谢关注";
				textMessage.setContent(respMessage);
				//将文本类容转化为xml格式
				 respXML = GeneratXml.messageToXML(textMessage);
				
			}

			else if (eventType.equals(EVENT_TYPE_UNSUBSCRIBE)) {
				// 取消关注接受不到信息
			}

			else if (eventType.equals(VENT_TYPE_QRCODE)) {
				// 扫描二维码
			}

			else if (eventType.equals(EVENT_TYPE_LOCATION)) {

				// 提交地理位置
			}

			
			else if (eventType.equals(EVENT_TYPE_MENU)) {

				// 自定义菜单
				//获取菜单的key值
				String evevtKey = message.get("EventKey");
				
				if(evevtKey.equals("cc")){
					
					Article article = new Article();
					article.setTitle("简介");
					article.setPicUrl("");
					article.setUrl("http://www.baidu.com");
					article.setDescription("ddasdasjdhxauhuwhudhuadwadfrersfe");
					java.util.List<Article> list = new ArrayList<Article>();
					list.add(article);
					
					//带图标的文章
					NewsMessage newsMessage = new NewsMessage();
					newsMessage.setArticleCount(list.size());
					newsMessage.setArticles(list);
					newsMessage.setCreateTime(new Date().getTime());
					newsMessage.setMsgType(RESP_MESSAGE_TYPE_NEWS);
					newsMessage.setToUserName(formUesrName);
					newsMessage.setFromUserName(toUserName);

					respXML = GeneratXml.messageToXML(newsMessage);
					
					
				} else if (evevtKey.equals("ccc")) {

					respMessage = "该功能暂未开放";
					textMessage.setContent(respMessage);
					respXML = GeneratXml.messageToXML(textMessage);

				} else if (evevtKey.equals("ccd")) {

					respMessage = "该功能暂未开放";
					textMessage.setContent(respMessage);
					respXML = GeneratXml.messageToXML(textMessage);

				}

			}
			
		}
		
		
		
		return respXML;
		
	}
	
}
