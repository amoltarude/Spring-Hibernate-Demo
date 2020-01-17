package com.sunbeaminfo.sh.onlinefood.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;
import com.sunbeaminfo.sh.onlinefood.entities.Item;

@WebServlet(value="/showcart")
public class ShowCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
	 	PrintWriter out = resp.getWriter();
	 	double total = 0.0;
	 	out.println("<html>");
	 	out.println("<head>");
	 	out.println("<title>Cart</title>");
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
	 	
	 	HttpSession session = req.getSession();
	 	List<Integer> cart = (List<Integer>) session.getAttribute("cart");
	 	
	 	out.println("<table border='1'>");
	 	out.println("<tr>");
	 	out.println("<td>Id</td><td>Name</td><td>Info</td><td>Category</td><td>Price</td>");
	 	out.println("</tr>");
	 	try(ItemDao dao = new ItemDao()) {
		 	dao.open();
	 		for (int id : cart) {
	 			Item item = dao.getItem(id);
			 	out.println("<tr>");
			 	out.printf("<td>%d</td><td>%s</td><td>%s</td>"
			 			+ "<td>%s</td><td>%.2f</td>\r\n", 
			 			id, item.getName(), item.getInfo(),
			 			item.getCategory(), item.getPrice());
			 	out.println("</tr>");			
			 	total = total + item.getPrice();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	 	out.println("</table>");
	 	out.printf("<h4>Total Price: %.2f/-</h4>\r\n", total);
	 	out.println("<a href='logout'>Sign Out</a>");
	 	out.println("</body>");
	 	out.println("</html>");
	}
}
