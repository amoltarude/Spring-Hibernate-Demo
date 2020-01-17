package com.sunbeaminfo.sh.onlinefood.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeaminfo.sh.onlinefood.daos.CustomerDao;
import com.sunbeaminfo.sh.onlinefood.entities.Customer;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Customer cust = null;
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			cust = dao.getCustomer(email);
			if(!password.equals(cust.getPassword()))
				cust = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cust!=null) {
			Cookie c = new Cookie("uname", cust.getName());
			resp.addCookie(c);
			
			/*
			//This code Shifted to HttpSessionListener
			HttpSession session = req.getSession();
			List<Integer> cart = new ArrayList<>();
			session.setAttribute("cart", cart);
			*/
			
			//resp.sendRedirect("categories");
			resp.sendRedirect(resp.encodeRedirectURL("categories"));
		} else {
			resp.setContentType("text/html");
		 	PrintWriter out = resp.getWriter();
		 	out.println("<html>");
		 	out.println("<head>");
		 	out.println("<title>Failed</title>");
		 	out.println("</head>");
		 	out.println("<body>");
		 	out.println("<h4>Invalid username or password.</h4>");
		 	out.println("<a href='index.html'>Login Again</a>");
		 	out.println("</body>");
		 	out.println("</html>");
		}
	}
}
