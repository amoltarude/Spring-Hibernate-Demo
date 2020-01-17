package com.sunbeaminfo.sh.onlinefood.beans;

import com.sunbeaminfo.sh.onlinefood.daos.CustomerDao;
import com.sunbeaminfo.sh.onlinefood.entities.Customer;

public class LoginBean {
	private String email;
	private String pass;
	public LoginBean() {
		this.email = "";
		this.pass = "";
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
	public boolean getStatus() {
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			Customer cust = dao.getCustomer(email);
			if(cust!=null && cust.getPassword().equals(pass))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
