package com.sunbeaminfo.sh.sp.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeaminfo.sh.sp.entities.Customer;

@Transactional(propagation=Propagation.MANDATORY, isolation=Isolation.SERIALIZABLE)
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory factory;
	public Customer getCustomerById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	public Customer getCustomerByEmail(String email) {
		Session session = factory.getCurrentSession();
		Query<Customer> q = session.createQuery("from Customer c where c.email=:p_email");
		q.setParameter("p_email", email);
		return q.getSingleResult();
	}
	public void saveCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.persist(customer);
	}
}
