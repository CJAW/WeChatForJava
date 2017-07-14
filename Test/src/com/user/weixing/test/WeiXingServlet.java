package com.user.weixing.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeiXingServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		//微信名
		String signature = req.getParameter("signature");
		//时间戳
		String timestamp = req.getParameter("timestamp");
        //随机数
		String nonce = req.getParameter("nonce");
		
		//随即字符串
		String echoster = req.getParameter("echoster");
		
		PrintWriter out = resp.getWriter();
		
		if(StringUtil.checkSignature(signature, timestamp, nonce)){
			
			out.print(echoster);
			
		}
		out.close();
		out = null;
		
	}

}
