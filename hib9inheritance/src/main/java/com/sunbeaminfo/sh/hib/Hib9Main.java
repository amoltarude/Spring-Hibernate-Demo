package com.sunbeaminfo.sh.hib;

import java.util.List;

public class Hib9Main {
	public static void main(String[] args) {
		
//		try {
//			HbUtil.beginTransaction();
//			ItemDao dao = new ItemDao();
//			List<Item> list = dao.getItems();
//			for (Item item : list)
//				System.out.println(item);
//			HbUtil.commitTransaction();
//		} catch (Exception e) {
//			HbUtil.rollbackTransaction();
//			e.printStackTrace();
//		}
		
		
		try {
			HbUtil.beginTransaction();
			ItemDao dao = new ItemDao();
			List<DosaItem> list = dao.getDosas();
			for (Item item : list)
				System.out.println(item);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		
		HbUtil.shutdown();
	}
}
