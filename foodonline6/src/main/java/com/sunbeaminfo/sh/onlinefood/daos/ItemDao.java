package com.sunbeaminfo.sh.onlinefood.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunbeaminfo.sh.onlinefood.entities.Item;
import com.sunbeaminfo.sh.onlinefood.utils.HbUtil;

public class ItemDao implements AutoCloseable {
	private Session session;
	public void open() throws Exception {
		session = HbUtil.getSession();
	}
	@Override
	public void close() throws Exception {
	}
	public List<String> getCategories() throws Exception {
		Query<String> q = session.getNamedQuery("qryCategories");
		return q.getResultList();
	}
	
	public List<Item> getItems(String category) throws Exception {
		Query<Item> q = session.getNamedQuery("qryCategoryItems");
		q.setParameter("p_category", category);
		return q.getResultList();
	}
	
	public Item getItem(int id) throws Exception {
		return session.get(Item.class, id);
	}
}
