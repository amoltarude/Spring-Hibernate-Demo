package com.sunbeaminfo.sh.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class DeptEmpDao {
	public List<Dept> getAllDepts() {
		String hql = "from Dept d";
		Session session = HbUtil.getSession();
		Query q = session.createQuery(hql);
		return q.getResultList();
	}
}
