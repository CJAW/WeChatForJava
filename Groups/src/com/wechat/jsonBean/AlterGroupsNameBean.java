package com.wechat.jsonBean;

/**
 * 修改后的分组
 * @author user
 *
 */
public class AlterGroupsNameBean {

	//要修改的id
	private int id;
	//修改后的名字
	private String name;
	
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
	
}
