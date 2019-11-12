package com.sc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(initParams=@WebInitParam(name="encoding",value="utf-8"),
urlPatterns="/*")
public class EncodingFilter implements Filter {
	String encoding=null;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)arg0;
		req.setCharacterEncoding(this.encoding);
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		this.encoding=arg0.getInitParameter("encoding");
	}

}
