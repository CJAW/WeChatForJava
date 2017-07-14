package com.wechat.customerData;
/**
 * 客服回复视屏消息
 * @author user
 *
 */
import java.util.Map;
public class Video extends DataBase {

	
	
	private Map<String,String> video;

	public Map<String, String> getVideo() {
		return video;
	}

	public void setVideo(Map<String, String> video) {
		this.video = video;
	}
	
	
}
