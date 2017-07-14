package com.wechat.https;

public class Access_TokenBean {

	//网页授权的凭证，与微信接口的access_token不同
	private String access_token;
	
	//凭证的使用时间
	private int expires_in;
	
	//用户刷新的access_token
	private String refresh_token;
	
	//用户唯一表示
	private String openid;
	
	//用户授权的作用域
	private String scope;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	
	
}
