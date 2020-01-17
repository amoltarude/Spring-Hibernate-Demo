package com.sunbeaminfo.sh.onlinefood.beans;

import com.sunbeaminfo.sh.onlinefood.daos.CustomerDao;
import com.sunbeaminfo.sh.onlinefood.entities.Customer;

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
		try(CustomerDao dao = new CustomerDao()) {
			dao.open();
			Customer cust = dao.getCustomer(email);
			if(cust!=null && cust.getPassword().equals(pass)) {
				this.name = cust.getName();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
