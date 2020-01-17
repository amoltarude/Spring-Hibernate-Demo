package com.sunbeaminfo.sh.hib;

import java.util.List;

public class Hib15Main {
	public static void main(String[] args) {
		try {
			DeptEmpDao dao = new DeptEmpDao();
			HbUtil.beginTransaction();
			List<Dept> list = dao.getAllDepts();
			HbUtil.commitTransaction();
			for (Dept d : list) {
				System.out.println("---" + d);
				for (Emp e : d.getEmpList()) {
					System.out.println(e);
				}
			}
			//HbUtil.commitTransaction();			
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}		
		HbUtil.shutdown();
	}
}
