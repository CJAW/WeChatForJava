package com.wechat.https;
/**
 * 用户的个人信息
 */
import java.util.List;

public class UserInformationBean {

	//用户唯一的标识
	private String openid;
	//用户昵称
	private String nickname;
	//用户性别
	private int sex;
	//用户个人资料的省份
	private String province;
	//用户个人资料的城市
	private String city;
	//用户个人资料的国家
	private String country;
	//用户头像
	private String headimgurl;
	//用户的特权
	private List<String> privilege;
	//绑定微信号的标识
	private String unionid;
	
	
	
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public List<String> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	
}
