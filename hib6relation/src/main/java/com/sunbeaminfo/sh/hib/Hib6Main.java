package com.sunbeaminfo.sh.hib;

import org.hibernate.Session;

public class Hib6Main {
	public static void main(String[] args) {
//		try {
//			Session session = HbUtil.getSession();
//			HbUtil.beginTransaction();
//			Emp e = session.get(Emp.class, 7900);
//			System.out.println(e);
//			System.out.println(e.getAddress());
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
//		try {
//			Session session = HbUtil.getSession();
//			HbUtil.beginTransaction();
//			Meeting m = session.get(Meeting.class, 1);
//			System.out.println(m);
//			for (Emp e : m.getEmpList())
//				System.out.println(e);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			e.printStackTrace();
//			HbUtil.rollbackTransaction();
//		}
		
		
	
		try {
			Session session = HbUtil.getSession();
			HbUtil.beginTransaction();
			Emp e = session.get(Emp.class, 7934);
			System.out.println(e);
			for (Meeting m : e.getMeetingList()) 
				System.out.println(m);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			HbUtil.rollbackTransaction();
		}
		
		
		HbUtil.shutdown();
	}
}
