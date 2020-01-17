package com.sunbeaminfo.sh.sp.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericXmlContextLoader;

import com.sunbeaminfo.sh.sp.entities.Customer;
import com.sunbeaminfo.sh.sp.services.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	loader=GenericXmlContextLoader.class,
	locations="classpath:beans.xml")
public class CustomerServiceImplTest {

	@Autowired
	private CustomerService custService;
	
	@Before
	public void setUp() throws Exception {
		// will execute before each test case
	}

	@After
	public void tearDown() throws Exception {
		// will execute after each test case
	}

	@Test
	public void testGetCustomerById() {
		Customer cust = custService.getCustomerById(1);
		assertTrue(cust!=null);		
	}

	@Test
	public void testGetCustomerByEmail() {
		Customer cust = custService.getCustomerByEmail("nilesh@sunbeaminfo.com");
		assertTrue(cust!=null);
	}

	@Test
	public void testGetCustomerByEmailAndPassword() {
		
	}

}
