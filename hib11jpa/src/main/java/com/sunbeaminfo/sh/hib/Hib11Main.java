package com.sunbeaminfo.sh.hib;

import java.util.List;
import java.util.Map;

public class Hib11Main {
	public static void main(String[] args) {
		
		try {
			BookDao dao = new BookDao();
			Book b = dao.getBook(11);
			System.out.println(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		try {
			BookDao dao = new BookDao();
			List<Book> list = dao.getBooksBySubject2("C");
			for (Book book : list) {
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			BookDao dao = new BookDao();
			Map<String, Double> map = dao.getSubjectwiseTotalPrice();
			map.forEach((k,v) -> System.out.println(k + " -> " + v));
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			BookDao dao = new BookDao();
			List<String> list = dao.getSubjects();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			BookDao dao = new BookDao();
			List<Book> list = dao.getBooksByAuthor("Kanetkar");
			for (Book book : list) {
				System.out.println(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			BookDao dao = new BookDao();
			int cnt = dao.updateBookPriceOfSubjectBy5Percent("Z");
			System.out.println("Rows Updated : " + cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
//		try {
//			BookDao dao = new BookDao();
//			int cnt = dao.deleteBooksBySubject("Z");
//			System.out.println("Rows Updated : " + cnt);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		JpaUtil.shutdown();
	}
}
