package com.sunbeaminfo.sh.onlinefood.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		RequestDispatcher rd = null;
		ServletContext ctx = this.getServletContext();
		System.out.println("****************");
		System.out.println(page);
		if(page.equals("login"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/login.jsp");
		else if(page.equals("index"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/index.jsp");
		else if(page.equals("categories"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/cats.jsp");
		else if(page.equals("items"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/items.jsp");
		else if(page.equals("addcart"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/addcart.jsp");
		else if(page.equals("showcart"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/showcart.jsp");
		else if(page.equals("logout"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/logout.jsp");
		else if(page.equals("login"))
			rd = ctx.getRequestDispatcher("/WEB-INF/views/login.jsp");
		else
			rd = ctx.getRequestDispatcher("/WEB-INF/views/index.jsp");
		rd.forward(req, resp);
	}
}
