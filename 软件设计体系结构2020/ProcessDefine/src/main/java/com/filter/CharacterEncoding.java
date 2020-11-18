package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncoding implements Filter {
	private String encoding;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("=====Character Filter ");
		if (encoding!=null) {
			//设置request字符编码
			request.setCharacterEncoding(encoding);
			//设置response字符编码
			response.setContentType("text/html;charset="+encoding);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
