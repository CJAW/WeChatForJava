package com.wechat.jsonBean;

/**
 * 
 * @author user
 *移动用户到指定的组
 */

public class MoveGroupsBean {

	//用户的id
	private String openid;
	//要移动到的组
	private int to_groupid;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getTo_groupid() {
		return to_groupid;
	}
	public void setTo_groupid(int to_groupid) {
		this.to_groupid = to_groupid;
	}
	
	
	
	
}
