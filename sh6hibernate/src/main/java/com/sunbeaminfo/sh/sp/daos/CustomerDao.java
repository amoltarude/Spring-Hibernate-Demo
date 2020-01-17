package com.sunbeaminfo.sh.sp.daos;

import com.sunbeaminfo.sh.sp.entities.Customer;

public interface CustomerDao {
	Customer getCustomerById(int id);
	Customer getCustomerByEmail(String email);
	void saveCustomer(Customer customer);
}
