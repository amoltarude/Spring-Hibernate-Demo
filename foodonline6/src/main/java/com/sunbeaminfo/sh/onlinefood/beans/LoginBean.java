package com.sunbeaminfo.sh.onlinefood.beans;

import com.sunbeaminfo.sh.onlinefood.daos.CustomerDao;
import com.sunbeaminfo.sh.onlinefood.entities.Customer;
import com.sunbeaminfo.sh.onlinefood.utils.HbUtil;

public class LoginBean {
	private String email;
	private String pass;
	private String name;
	public LoginBean() {
		this.email = "";
		this.pass = "";
		this.name = "";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getStatus() {
		boolean success = false;
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			HbUtil.beginTransaction();
			Customer cust = dao.getCustomer(email);
			if(cust!=null && cust.getPassword().equals(pass)) {
				this.name = cust.getName();
				success = true;
			}
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
			e.printStackTrace();
		}
		return success;
	}
}
