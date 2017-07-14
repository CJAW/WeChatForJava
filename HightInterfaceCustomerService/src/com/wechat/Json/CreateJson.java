package com.wechat.Json;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wechat.customerData.Article;
import com.wechat.customerData.Image;
import com.wechat.customerData.Music;
import com.wechat.customerData.News;
import com.wechat.customerData.Text;
import com.wechat.customerData.Video;
import com.wechat.customerData.Voice;

public class CreateJson {

	private static final String Make_to_json_type_text = "text";
	private static final String Make_to_json_type_image = "image";
	private static final String Make_to_json_type_voice = "voice";
	private static final String Make_to_json_type_video = "video";
	private static final String Make_to_json_type_music = "music";
	private static final String Make_to_json_type_news = "news";
	
	/**
	 * 发送文本消息
	 * @param OPENID
	 * @param content
	 * @return
	 */
	public static String makeTextToJson(String OPENID,String content){
		
		Text text = new Text();
		text.setMsgtype(Make_to_json_type_text);
		// 微信号
		text.setTouser(OPENID);
		Map<String,String> map = new HashMap<String,String>();
		map.put("content",content);
		text.setText(map);
		
		//创建gson对象，GsonBuilder()创建json的规则。
		//disableHtmlEscaping(),防止转化成unicode编码。
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(text);
	}
	
	/**
	 * 发送图片消息
	 */
	public static String makeImageToJson(String OPENID,String media_id){
		Image image = new Image();
		image.setMsgtype(Make_to_json_type_image);
		image.setTouser(OPENID);
		Map<String,String> map = new HashMap<String,String>();
		map.put("media_id", media_id);
		image.setImage(map);
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(image);
	}
	
	
	/**
	 * 发送语音消息
	 */
	public static String makeVoiceToJson(String OPENID,String media_id){
		Voice voice = new Voice();
		voice.setMsgtype(Make_to_json_type_voice);
		voice.setTouser(OPENID);
		Map<String,String> map = new HashMap<String,String>();
		map.put("media_id", media_id);
		voice.setVoice(map);
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(voice);
	}
	
	
	
	/**
	 * 发送视屏消息
	 */
	public static String makeVideoToJson(String OPENID,String media_id,String thumb_media_id){
		Video video = new Video();
		video.setMsgtype(Make_to_json_type_video);
		video.setTouser(OPENID);
		Map<String,String> map = new HashMap<String,String>();
		map.put("media_id", media_id);
		map.put("thumb_media_id", thumb_media_id);
		video.setVideo(map);
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(video);
	}
	
	/**
	 * 发送音乐消息
	 */
	public static String makeMusicToJson(String OPENID,String title,String des,String url,String hq,String tmi){
		Music music = new Music();
		music.setMsgtype(Make_to_json_type_music);
		music.setTouser(OPENID);
		Map<String,String> map = new HashMap<String,String>();
		map.put("title", title);
		map.put("description", des);
		map.put("musicurl", url);
		map.put("hqmusicurl", hq);
		map.put("thumb_media_id", tmi);
		music.setMusic(map);
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(music);
	}
	
	
	
	/**
	 * 发送图文消息
	 */
	public static String makeNewsToJson(String OPENID,List<Article> article){
		News news = new News();
		news.setMsgtype(Make_to_json_type_news);
		news.setTouser(OPENID);
		
		
		Map<String,List<Article>> map = new HashMap<String,List<Article>>();
	   
		map.put("articles",article);
		
		
		news.setNews(map);
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.toJson(news);
		
	}
	
	

}



