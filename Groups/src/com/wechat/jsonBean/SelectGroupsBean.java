package com.wechat.jsonBean;

/**
 * 
 * @author user
 *查询出得分组数据
 */

public class SelectGroupsBean {

	//分组id
	private int id;
	//分组名称
	private String name;
	//分组的用户数量
	private int count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
