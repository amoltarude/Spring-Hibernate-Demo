package com.sunbeaminfo.sh.sp.services;

import com.sunbeaminfo.sh.sp.entities.Customer;

public interface CustomerService {
	Customer getCustomerById(int id);
	Customer getCustomerByEmail(String email);
	void saveCustomer(Customer customer);
	Customer getCustomerByEmailAndPassword(String email, String password);
}
