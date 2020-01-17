package com.sunbeaminfo.sh.hib;

import org.hibernate.Session;

public class Hib8Main {
	public static void main(String[] args) {
		
//		try {
//			HbUtil.beginTransaction();
//			Session session = HbUtil.getSession();
//			Item i = new Item(0, "A", "B", "C", 4);
//			session.persist(i);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
//		
		
		
//		try {
//			HbUtil.beginTransaction();
//			Session session = HbUtil.getSession();
//			Student s = new Student(new StudStdRoll(3, 1), "Vendant", 94.3);
//			session.persist(s);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
		
		try {
			HbUtil.beginTransaction();
			Session session = HbUtil.getSession();
			Student s = session.get(Student.class, new StudStdRoll(3, 1));
			System.out.println(s);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		HbUtil.shutdown();
	}
}
