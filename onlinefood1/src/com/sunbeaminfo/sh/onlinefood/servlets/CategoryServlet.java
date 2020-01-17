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

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;

public class CategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> catList = new ArrayList<String>();
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			catList = dao.getCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
	 	PrintWriter out = resp.getWriter();
	 	out.println("<html>");
	 	out.println("<head>");
	 	out.println("<title>Categories</title>");
	 	out.println("</head>");
	 	out.println("<body>");
	 	
	 	Cookie[] arr = req.getCookies();
	 	if(arr != null) {
		 	for (Cookie c : arr) {
				if(c.getName().equals("uname")) {
					String name = c.getValue();
					out.printf("Hello, %s <hr/>\r\n", name);
					break;
				}
			}
	 	}
	 	
	 	out.println("<form method='post' action='items'>");
	 	for (String category : catList) {
	 		out.printf("<input type='radio' name='category' value='%s'/>%s <br/>\r\n", category, category);
		}
	 	out.println("<input type='submit' value='Show Items'/>");
	 	out.println("<a href='showcart'>Show Cart</a>");
	 	out.println("</form>");
	 	
	 	if(req.getAttribute("newItemCount") != null) {
	 		int newItemCount = (Integer)req.getAttribute("newItemCount");
	 		out.println("New Items Added to Cart : " + newItemCount + "<br/>");
	 		int allItemCount = (Integer)req.getAttribute("allItemCount");
	 		out.println("All Items Added to Cart : " + allItemCount + "<br/>");
	 	}
	 	out.println("</body>");
	 	out.println("</html>");
	}
}
