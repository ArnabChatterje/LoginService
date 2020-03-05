package com.example.LoginService.Security.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/*")
	public class HttpToHttpsFilter implements Filter{
	
	private static final String HTTPS="https";
	  
	  @Override
	  public void init (FilterConfig filterConfig) throws ServletException {

	  }


	  @Override
	  public void destroy () {

	  }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

	      String serverName=request.getServerName();
	      String path=((HttpServletRequest) request).getRequestURI();
	      String port = Integer.toString(request.getServerPort());
	
	      if(!request.getScheme().equalsIgnoreCase(HTTPS)) {
	    	  
	    	 String finalUrl=HTTPS+"://"+serverName+path+":"+port;
	    	 ((HttpServletResponse)response).sendRedirect(finalUrl);
	    	  
	      }
	      chain.doFilter(request, response);
	  
		
	}
	}

