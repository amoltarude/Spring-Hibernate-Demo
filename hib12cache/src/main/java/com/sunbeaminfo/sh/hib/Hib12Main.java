package com.sunbeaminfo.sh.hib;

import java.util.List;

import org.hibernate.Session;

public class Hib12Main {
	public static void main(String[] args) {
	
//		try(Session session = HbUtil.getSession()) {
//			Book b = session.get(Book.class, 11);
//			System.out.println("ID : " + b.getId()); 
//			System.out.println("NAME : " + b.getName());
//			System.out.println(b.getClass().getName());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println();
//		try(Session session = HbUtil.getSession()) {
//			Book b = session.load(Book.class, 11);
//			System.out.println("ID : " + b.getId()); 
//			System.out.println("NAME : " + b.getName());
//			System.out.println(b.getClass().getName());
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	
		
		
//		try(Session session = HbUtil.getSession()) {
//			Book b = session.get(Book.class, 11);
//			System.out.println(b);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try(Session session = HbUtil.getSession()) {
//			Book b = session.get(Book.class, 11);
//			System.out.println(b);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	
		
		try(Session session = HbUtil.getSession()) {
			List<Book> list = session.createQuery("from Book b where b.subject=:p_subject")
						.setParameter("p_subject", "C")
						.setCacheable(true)
						.getResultList();
			for (Book b : list) 
				System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try(Session session = HbUtil.getSession()) {
			List<Book> list = session.createQuery("from Book b where b.subject=:p_subject")
						.setParameter("p_subject", "C")
						.setCacheable(true)
						.getResultList();
			for (Book b : list) 
				System.out.println(b);
		}catch (Exception e) {
			e.printStackTrace();
		}
		HbUtil.shutdown();
	}
}
