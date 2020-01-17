package com.sunbeaminfo.sh.onlinefood.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		
		String[] itemIds = req.getParameterValues("item");
		for (String itemId : itemIds) {
			int id = Integer.parseInt(itemId);
			cart.add(id);
		}

		req.setAttribute("newItemCount", itemIds.length);
		req.setAttribute("allItemCount", cart.size());
		
		RequestDispatcher rd = req.getRequestDispatcher("categories");
		rd.forward(req, resp);
	}
}
