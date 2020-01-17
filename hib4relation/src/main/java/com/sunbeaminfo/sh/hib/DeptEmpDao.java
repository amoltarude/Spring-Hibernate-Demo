package com.sunbeaminfo.sh.hib;

import org.hibernate.Session;

public class DeptEmpDao {
	public Dept getDeptById(int deptno) {
		Session session = HbUtil.getSession();
		return session.get(Dept.class, deptno);
	}
	public void addDept(Dept d) {
		Session session = HbUtil.getSession();
		session.persist(d);
	}
	public void delDept(Dept d) {
		Session session = HbUtil.getSession();
		session.remove(d);
	}
	public void mergeDept(Dept d) {
		Session session = HbUtil.getSession();
		session.merge(d);
	}
}
