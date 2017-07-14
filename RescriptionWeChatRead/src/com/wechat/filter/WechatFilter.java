package com.wechat.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.management.resources.agent;

/**
 * 使用过滤器对微信的游览器进行限制，只能访问微信的游览器
 * @author user
 *
 */

public class WechatFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
		HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
		httpServletRequest.setCharacterEncoding("UTF-8");
		httpServletResponse.setCharacterEncoding("UTF-8");
		
		String userAgent = (String) httpServletRequest.getAttribute("User-Agent");
		if(userAgent.equals("MicroMessenger")){
			
		arg2.doFilter(arg0, arg1);
		
		}else {
			
			PrintWriter printWriter = httpServletResponse.getWriter();
			printWriter.write("请使用微信的游览器");
			printWriter.close();
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
