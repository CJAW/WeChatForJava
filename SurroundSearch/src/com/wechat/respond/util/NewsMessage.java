package com.wechat.respond.util;

import java.util.List;

/**
 * 开发者服务器向用户发送图文消息
 * @author user
 *
 */
public class NewsMessage extends BaseMessage{

	//图文消息个数，10个以内
	private int ArticleCount;
	//多条图文消息，默认第一个item位大图
	private List<Article> Articles;
	
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
	
	
}
