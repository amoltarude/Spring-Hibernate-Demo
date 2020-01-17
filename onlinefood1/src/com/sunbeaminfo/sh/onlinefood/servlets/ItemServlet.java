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
import com.sunbeaminfo.sh.onlinefood.entities.Item;

public class ItemServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String category = req.getParameter("category");
		
		List<Item> itemList = new ArrayList<>();
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			itemList = dao.getItems(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
	 	PrintWriter out = resp.getWriter();
	 	out.println("<html>");
	 	out.println("<head>");
	 	out.println("<title>Items</title>");
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

	 	out.println("<form method='post' action='addcart'>");
	 	for (Item item : itemList) {
	 		out.printf("<input type='checkbox' name='item' value='%d'/>%s <br/>\r\n", item.getId(), item.getName());
		}
	 	out.println("<input type='submit' value='Add Cart'/>");
	 	out.println("</form>");
	 	out.println("</body>");
	 	out.println("</html>");
	}

}
