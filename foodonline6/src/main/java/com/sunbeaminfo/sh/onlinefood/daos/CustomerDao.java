package com.sunbeaminfo.sh.onlinefood.daos;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.sunbeaminfo.sh.onlinefood.entities.Customer;
import com.sunbeaminfo.sh.onlinefood.utils.HbUtil;

public class CustomerDao implements AutoCloseable {
	private Session session;
	public void open() throws Exception {
		session = HbUtil.getSession();	
	}
	@Override
	public void close() throws Exception {
	}
	public Customer getCustomer(String email) throws Exception {
		String hql = "from Customer c where c.email=:p_email";
		Query<Customer> q = session.createQuery(hql);
		q.setParameter("p_email", email);
		return q.getSingleResult();
	}
	public Customer getCustomerByMobile(String mobile) throws Exception {
		String hql = "from Customer c where c.mobile=:p_mobile";
		Query<Customer> q = session.createQuery(hql);
		q.setParameter("p_mobile", mobile);
		return q.getSingleResult();
	}
}
