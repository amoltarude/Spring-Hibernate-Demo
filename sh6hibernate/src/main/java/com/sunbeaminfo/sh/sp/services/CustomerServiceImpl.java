package com.sunbeaminfo.sh.sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeaminfo.sh.sp.daos.CustomerDao;
import com.sunbeaminfo.sh.sp.entities.Customer;

//@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;
	
	@Transactional
	public Customer getCustomerById(int id) {
		return custDao.getCustomerById(id);
	}

	@Transactional
	public Customer getCustomerByEmail(String email) {
		return custDao.getCustomerByEmail(email);
	}

	@Transactional
	public void saveCustomer(Customer customer) {
		custDao.saveCustomer(customer);
	}

	@Transactional
	public Customer getCustomerByEmailAndPassword(String email, String password) {
		Customer cust = this.getCustomerByEmail(email);
		if(cust != null && password.equals(cust.getPassword()))
			return cust;
		return null;
	}

}
