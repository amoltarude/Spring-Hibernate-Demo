package com.sunbeaminfo.sh.onlinefood.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sunbeaminfo.sh.onlinefood.daos.ItemDao;
import com.sunbeaminfo.sh.onlinefood.entities.Item;

public class ItemTag extends SimpleTagSupport {
	private int id;
	public ItemTag() {
		this.id = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public void doTag() throws JspException, IOException {
		// business logic
		Item item = null;
		try(ItemDao dao = new ItemDao()) {
			dao.open();
			item = dao.getItem(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		// presentation logic
		if(item!=null) {
			PageContext pageContext = (PageContext) this.getJspContext();
			JspWriter out = pageContext.getOut();
			out.println("<tr>");
			out.println("<td>" + item.getId() + "</td>");
			out.println("<td>" + item.getCategory() + "</td>");
			out.println("<td>" + item.getName() + "</td>");
			out.println("<td>" + item.getPrice() + "</td>");
			out.println("</tr>");
			pageContext.setAttribute("price", item.getPrice());
		}
	}
}



