package com.wechat.create_menu;

import com.google.gson.Gson;
import com.wechat.button.BaseButton;
import com.wechat.button.ClickButton;
import com.wechat.button.ComplexButton;
import com.wechat.button.ViewButton;

/**
 * 创建自定义的菜单
 * @author user
 *
 */
public class CreateMenu {
	
   public String  getMenuJson(){
	   //定义一级click按钮
	   ClickButton clickButton =new ClickButton();
	   clickButton.setName("click按钮");
	   clickButton.setType("click");
	   clickButton.setKey("cc");
	   
	   
	   //定义一级view按钮
	   ViewButton viewButton =new ViewButton();
	   viewButton.setName("view按钮");
	   viewButton.setType("view");
	   viewButton.setUrl("http://www.baidu.com");
	   
	   //定义二级子菜单
	   ClickButton clickButtonSub_1 =new ClickButton();
	   clickButtonSub_1.setName("二级click按钮1");
	   clickButtonSub_1.setType("click");
	   clickButtonSub_1.setKey("ccc");

	   ClickButton clickButtonSub_2 =new ClickButton();
	   clickButtonSub_2.setName("二级click按钮2");
	   clickButtonSub_2.setType("click");
	   clickButtonSub_2.setKey("ccd");
	   
	   //创建
	   ComplexButton complexButton = new ComplexButton();
	   complexButton.setSub_button(new BaseButton[]{clickButtonSub_1,clickButtonSub_2});
	    complexButton.setName("多级");
	   //创建菜单
	   com.wechat.button.Menu menu = new com.wechat.button.Menu();
	   menu.setButton(new BaseButton[]{clickButton,viewButton,complexButton});
	   
	   //将菜单格式转化为json
	   Gson gson = new Gson();
	   String Message = gson.toJson(menu);
	   return Message;
	   
   }
   
}
