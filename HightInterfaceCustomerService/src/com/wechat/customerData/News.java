package com.wechat.customerData;
import java.util.List;
/**
 * 客服回复图文消息
 * @author user
 *
 */
import java.util.Map;
public class News extends DataBase{

	private Map<String,List<Article>> news;

	public Map<String, List<Article>> getNews() {
		return news;
	}

	public void setNews(Map<String, List<Article>> news) {
		this.news = news;
	}

	

	
	
}
