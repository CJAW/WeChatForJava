package com.wechat.connection_check.util;

/**
 * 对用户连接公众号进行效验
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class WeChatServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;


	
	//进行请求效验
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//微信公众号要utf－8的编码
			req.setCharacterEncoding("UTF-8");
			// 微信名
			String signature = req.getParameter("signature");
			// 时间戳
			String timestamp = req.getParameter("timestamp");
			// 随机数
			String nonce = req.getParameter("nonce");

			// 随即字符串
			String echostr = req.getParameter("echostr");

			PrintWriter out = resp.getWriter();

			//对信息进行验证
			if (StringUtil.checkSignature(signature, timestamp, nonce)) {
	        
				//返回消息到微信服务器
				out.print(echostr);

			}
			out.close();
			out = null;
			
			
					
		}
//		
//
//	//进行逻辑操作
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//微信公众号要utf－8的编码
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		// 微信名
//		String signature = req.getParameter("signature");
//		// 时间戳
//		String timestamp = req.getParameter("timestamp");
//		// 随机数
//		String nonce = req.getParameter("nonce");
//
//		// 随即字符串
//		//String echoster = req.getParameter("echostr");
//
//		PrintWriter out = resp.getWriter();
//
//		//对信息进行验证，防止恶意输入
//		if (StringUtil.checkSignature(signature, timestamp, nonce)) {
//        
//			//将 要返回的消息包装成XML格式
//			String XML = WeChatService.process(req);
//			
//			System.out.println(XML);
//			//返回xml消息到微信服务器,在发送到用户
//			out.print(XML);
//
//		}
//		out.close();
//		out = null;
//		
//	}

}
