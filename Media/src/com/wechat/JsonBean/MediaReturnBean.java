package com.wechat.JsonBean;

/**
 * 上传成功多媒体后的返回
 * @author user
 *
 */
public class MediaReturnBean {

	//文件类型
	private String Type;
	//上传后的id
	private String media_id;
	//上传的时间
	private int create_at;
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public int getCreate_at() {
		return create_at;
	}
	public void setCreate_at(int create_at) {
		this.create_at = create_at;
	}

	
}
