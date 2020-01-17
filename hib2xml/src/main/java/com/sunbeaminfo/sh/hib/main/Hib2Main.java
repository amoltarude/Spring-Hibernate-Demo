package com.sunbeaminfo.sh.hib.main;

import com.sunbeaminfo.sh.hib.daos.CustomerDao;
import com.sunbeaminfo.sh.hib.entities.Customer;
import com.sunbeaminfo.sh.hib.util.HbUtil;

public class Hib2Main {
	public static void main(String[] args) {
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			Customer cust = dao.getCustomerById(5);
			if(cust == null)
				System.out.println("Customer Not Found");
			else
				System.out.println(cust.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			Customer cust = new Customer(5, "Abc", "Pqr", "abc@gmail.com", "1234567890", "Xyz");
			dao.addCustomer(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			Customer cust = dao.getCustomerById(5);
			if(cust == null)
				System.out.println("Customer Not Found");
			else {
				cust.setAddress("Lmn");
				cust.setName("Def");
				dao.updateCustomer(cust);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			dao.deleteCustomerById(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		HbUtil.shutdown();
	}
}
