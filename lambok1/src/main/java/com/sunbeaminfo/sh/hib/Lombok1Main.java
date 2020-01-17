package com.sunbeaminfo.sh.hib;

public class Lombok1Main {
	public static void main(String[] args) {
		//DeptDao dao = DeptDao.createInstance();
		//dao.addDept(new Dept(70, "Abc", "Pqr"));
		
		DeptDao dao = DeptDao.createInstance();
		Dept d = dao.getDept(10);
		System.out.println(d);
		
		HbUtil.shutdown();
	}
}
