package com.wechat.button;
/**
 * 复合型的button，含有多级子菜单
 * @author user
 *
 */
public class ComplexButton extends BaseButton{
	
	private BaseButton[] sub_button;

	public BaseButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(BaseButton[] sub_button) {
		this.sub_button = sub_button;
	}

	


	
	

}
