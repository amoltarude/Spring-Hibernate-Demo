package com.sunbeaminfo.sh.onlinefood.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class OnlineFoodAppFilter implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("OnlineFoodAppFilter.init() called...");
	}

	@Override
	public void destroy() {
		System.out.println("OnlineFoodAppFilter.destroy() called...");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// check if cookie "uname" is present.
		boolean auth = false;
		Cookie[] arr = ((HttpServletRequest)req).getCookies();
		if(arr != null) {
			for (Cookie c: arr) {
				if(c.getName().equals("uname")) {
					if(c.getValue()!=null && !c.getValue().isEmpty())
						auth = true;
					break;
				}
			}
		}

		// bypass security for login page and login servlet.
		String uri = ((HttpServletRequest)req).getRequestURI();
		System.out.println("Requested URI : " + uri);
		if(uri.contains("index.html") || uri.contains("login"))
			auth = true;

		// call this only when cookie is present.
		if(auth)
			chain.doFilter(req, resp);
		else { // otherwise send error or redirect to login page.
			//((HttpServletResponse)resp).sendError(403);
			((HttpServletResponse)resp).sendRedirect("index.html");
		}
	}
}
