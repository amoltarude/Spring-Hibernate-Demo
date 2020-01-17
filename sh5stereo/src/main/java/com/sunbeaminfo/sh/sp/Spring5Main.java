package com.sunbeaminfo.sh.sp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring5Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx 
			= new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		
		PersonImpl p1 = ctx.getBean(PersonImpl.class);
		p1.setName("Amol");
		p1.setAge(28);
		p1.setMobile("9923188034");
		System.out.println(p1);
		
		AccountImpl a1 = ctx.getBean(AccountImpl.class);
		a1.setAccId(101);
		a1.setType("Savings");
		a1.setBalance(1000);
		System.out.println(a1);
	
		System.out.println("Balance : " + a1.getBalance()); // 1000
		
		a1.deposit(5000);
		System.out.println("Balance : " + a1.getBalance()); // 6000
		
		a1.withdraw(2000);
		System.out.println("Balance : " + a1.getBalance()); // 4000
		
	}
}
