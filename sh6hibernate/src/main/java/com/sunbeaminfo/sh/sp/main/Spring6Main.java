package com.sunbeaminfo.sh.sp.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sunbeaminfo.sh.sp.entities.Customer;
import com.sunbeaminfo.sh.sp.services.CustomerService;

public class Spring6Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx 
		 	= new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		
		CustomerService custService = ctx.getBean(CustomerService.class);
		Customer cust = custService.getCustomerByEmailAndPassword("amoltarude@gmail.com", "amol");
		if(cust!=null)
			System.out.println(cust);
		else
			System.out.println("Invalid Customer");
	}
}
