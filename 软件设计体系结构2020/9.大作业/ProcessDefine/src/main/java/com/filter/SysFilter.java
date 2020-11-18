package com.filter;

import com.pojo.User;
import com.tools.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("SysFilter doFilter()===========");
		HttpServletRequest rq = (HttpServletRequest)request;
		HttpServletResponse rp = (HttpServletResponse)response;
		User userSession = (User)rq.getSession().getAttribute(Constants.USER_SESSION);
		if(null == userSession){
			rp.sendRedirect("/pd/error.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
