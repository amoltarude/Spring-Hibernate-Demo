package com.sunbeaminfo.sh.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring7Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("beans2.xml");
		ctx.registerShutdownHook();
		
		Person p1 = ctx.getBean(Person.class);
		System.out.println(p1);
		
		Account a1 = ctx.getBean(Account.class);
		System.out.println(a1);
		
		a1.setType("Savings");
		
		System.out.println("ACCOUNT : " + a1.getClass().getName());
		
		a1.withdraw(1000);
		
		double bal = a1.getBalance();
		System.out.println("Balance : " + bal);
		
		AccountInfoImpl ai1 = ctx.getBean(AccountInfoImpl.class);
		System.out.println(ai1);
	}
}
