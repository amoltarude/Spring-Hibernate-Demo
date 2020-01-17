package com.sunbeaminfo.sh.hib;

import org.hibernate.Session;

public class DeptDaoImpl implements DeptDao {
	public void addDept(Dept d) {
		Session session = HbUtil.getSession();
		session.persist(d);
	}
	@Transaction
	public Dept getDept(int deptno) {
		Session session = HbUtil.getSession();
		return session.get(Dept.class, deptno);
	}
}
