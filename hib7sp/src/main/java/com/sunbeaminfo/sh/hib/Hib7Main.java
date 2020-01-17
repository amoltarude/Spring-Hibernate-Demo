package com.sunbeaminfo.sh.hib;

import java.util.List;

public class Hib7Main {
	public static void main(String[] args) {
		try {
			DeptDao dao = new DeptDao();
			HbUtil.beginTransaction();
			String loc = dao.getLoc5(30);
			System.out.println("Location : " + loc);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		/*
		try {
			DeptDao dao = new DeptDao();
			HbUtil.beginTransaction();
			String loc = dao.getLoc3(30);
			System.out.println("Location : " + loc);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*
		try {
			DeptDao dao = new DeptDao();
			HbUtil.beginTransaction();
			int cnt = dao.updateLoc(60, "Hydrabad");
			System.out.println("Updated : " + cnt);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		/*
		try {
			DeptDao dao = new DeptDao();
			HbUtil.beginTransaction();
			List<Dept> list = dao.getAllDepts();
			for (Dept d : list) 
				System.out.println(d);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		*/
		HbUtil.shutdown();
	}
}
