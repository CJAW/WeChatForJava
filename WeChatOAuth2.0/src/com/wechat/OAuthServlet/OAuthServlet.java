package com.wechat.OAuthServlet;
/**
 * 引导用户对网页进行授权
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.https.Access_TokenBean;
import com.wechat.https.GetAccess_Token;
import com.wechat.https.GetUesrInformation;
import com.wechat.https.UserInformationBean;

public class OAuthServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//用户同意授权
		String codes = req.getParameter("code");
		
		
		Access_TokenBean access_TokenBean = GetAccess_Token.getAccess_token(codes);
		String access_token = access_TokenBean.getAccess_token();
		String oppenid = access_TokenBean.getOpenid();
		String lang = "zh_CN ";
		
		
		
		UserInformationBean userInformationBean = GetUesrInformation.getUserInformation(access_token, oppenid, lang);
		
		
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Success/Success.jsp");
			req.setAttribute("userInformation", userInformationBean);
			requestDispatcher.forward(req, resp);
					
			
		
	}

}
