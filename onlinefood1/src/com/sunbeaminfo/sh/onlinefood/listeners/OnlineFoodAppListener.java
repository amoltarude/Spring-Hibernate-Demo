package com.sunbeaminfo.sh.onlinefood.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class OnlineFoodAppListener implements ServletContextListener, HttpSessionListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		System.out.println("contextInitialized called...");
		// init for the whole appln.
		// will be executed as soon as appln is deployed.
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed called...");
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		HttpSession session = hse.getSession();
		List<Integer> cart = new ArrayList<>();
		session.setAttribute("cart", cart);
		System.out.println("sessionCreated called...");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("sessionDestroyed called...");
	}
}
