package com.wechat.create_menu;

import com.google.gson.Gson;
import com.wechat.https.GetAccess_Token;
import com.wechat.https.HttpsConUtil;
import com.wechat.https.ResultBean;

/**
 * 将菜单部署到微信的服务器
 * @author user
 *
 */

public class CreateCurrentMenu {

	public void createCurrentMenu() {

		// 发布菜单的URL
		String Url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ GetAccess_Token.getAccess_token();

		String resutl = HttpsConUtil.request(Url, "POST", "UTF-8");
		// System.out.println(resutl);

		// 解析json使用 Gson,获取服务器的返回数据
		Gson gson = new Gson();
		ResultBean messages = gson.fromJson(resutl.toString(), ResultBean.class);

		int message = messages.getErrcode();

		if (message == 0) {
			System.out.println("部署成功！");
		} else {
			System.out.println("失败！");
		}

	}

	public static void main(String[] args) {
		CreateCurrentMenu createCurrentMenu = new CreateCurrentMenu();

		createCurrentMenu.createCurrentMenu();
	}
}
