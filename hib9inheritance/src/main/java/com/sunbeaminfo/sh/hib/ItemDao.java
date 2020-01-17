package com.sunbeaminfo.sh.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ItemDao {
	public List<Item> getItems() {
		Session session = HbUtil.getSession();
		Query<Item> q = session.createQuery("from Item i");
		return q.getResultList();
	}
	
	public List<DosaItem> getDosas() {
		Session session = HbUtil.getSession();
		Query<DosaItem> q = session.createQuery("from DosaItem d");
		return q.getResultList();
	}
	
	// ...
}
