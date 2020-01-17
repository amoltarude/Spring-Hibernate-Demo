package com.sunbeaminfo.sh.first.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class MyServlet extends HttpServlet {
	private String color = "";
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("MyServlet.init() called...");
		// initialization code
		color = config.getInitParameter("color");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyServlet.doGet() called...");
		Date d = new Date();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>\r\n", color);
		out.println("<h2>Wake up from Hibernate & Spring Up!!</h2>");	
		out.printf("<h4>System Date : %s</h4>\r\n", d.toString());
		out.println("</body>");
		out.println("</html>");
	}
	public void destroy() {
		System.out.println("MyServlet.destroy() called...");
	}
}
