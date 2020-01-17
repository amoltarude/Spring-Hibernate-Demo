package com.sunbeaminfo.sh.onlinefood.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		if(page.equals("login"))
			rd = req.getRequestDispatcher("login.jsp");
		else if(page.equals("index"))
			rd = req.getRequestDispatcher("index.jsp");
		else if(page.equals("categories"))
			rd = req.getRequestDispatcher("cats.jsp");
		else if(page.equals("items"))
			rd = req.getRequestDispatcher("items.jsp");
		else if(page.equals("addcart"))
			rd = req.getRequestDispatcher("addcart.jsp");
		else if(page.equals("showcart"))
			rd = req.getRequestDispatcher("showcart.jsp");
		else if(page.equals("logout"))
			rd = req.getRequestDispatcher("logout.jsp");
		else if(page.equals("login"))
			rd = req.getRequestDispatcher("login.jsp");
		else
			rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
