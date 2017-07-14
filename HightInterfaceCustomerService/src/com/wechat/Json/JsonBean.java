package com.wechat.Json;

import com.wechat.customerData.Image;
import com.wechat.customerData.Music;
import com.wechat.customerData.News;
import com.wechat.customerData.Text;
import com.wechat.customerData.Video;
import com.wechat.customerData.Voice;

/**
 * 创建json的bean
 * @author user
 *
 */
public class JsonBean {

	private Text text;
	private Image image;
	private Music music;
	private Video video;
	private Voice vioce;
	private News[] news;
	
	
	
	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Voice getVioce() {
		return vioce;
	}

	public void setVioce(Voice vioce) {
		this.vioce = vioce;
	}

	public News[] getNews() {
		return news;
	}

	public void setNews(News[] news) {
		this.news = news;
	}
	
}
