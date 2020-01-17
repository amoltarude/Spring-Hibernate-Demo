package com.sunbeaminfo.sh.hib;

import org.hibernate.Session;

public class DeptEmpDao {
	public Emp getEmpById(int empno) {
		Session session = HbUtil.getSession();
		return session.get(Emp.class, empno);
	}
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
}
