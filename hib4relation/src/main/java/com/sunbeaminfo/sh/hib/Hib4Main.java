package com.sunbeaminfo.sh.hib;

import java.util.ArrayList;
import java.util.List;

public class Hib4Main {
	public static void main(String[] args) {
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			Dept d = new Dept(60, "Dev", "Mumbai");
			dao.mergeDept(d);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
		
		/*
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			Dept d = dao.getDeptById(60);
			if(d == null)
				System.out.println("Dept Not Avail.");
			else {
				System.out.println(d);
				dao.delDept(d);
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			
			Dept d = new Dept(60, "Security", "Kashmir");
			
			List<Emp> el = new ArrayList<Emp>();
			el.add(new Emp(100, "A", 10000, 60));
			el.add(new Emp(200, "B", 20000, 60));
			el.add(new Emp(300, "C", 30000, 60));
			
			d.setEmpList(el);
			
			dao.addDept(d);
			
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
		*/
		
		/*
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			Dept d = dao.getDeptById(10);
			if(d == null)
				System.out.println("Dept Not Avail.");
			else {
				System.out.println(d);
				for (Emp e : d.getEmpList()) {
					System.out.println(e);
				}
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
		*/
		
		HbUtil.shutdown();
	}
}
