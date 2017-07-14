package com.wechat.jsonBean;

import java.util.List;
import java.util.Map;

/**
 * 获取用户的openID
 * @author user
 *
 */

public class GetOpenIDJsonBean {

	//关注该公众账号的总用户数
	private int total;
	//拉取的OPENID个数，最大值为10000
	private int count;
	//拉取列表的最后一个用户的OPENID
	private String next_openid;
	//列表数据，OPENID的列表
	private Map<String,List<String>> data;
	//总数
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}
	public Map<String, List<String>> getData() {
		return data;
	}
	public void setData(Map<String, List<String>> data) {
		this.data = data;
	}
	
	
	
}
