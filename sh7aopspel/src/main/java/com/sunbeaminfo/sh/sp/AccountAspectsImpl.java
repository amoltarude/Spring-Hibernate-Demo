package com.sunbeaminfo.sh.sp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspectsImpl {
	@Before("execution (* Account.get*(..))")
	public void beforeGetter(JoinPoint jpt) {
		System.out.println("BEFORE GETTER :: " + jpt.getSignature());
	}
	
	@After("execution (* Account.set*(..))")
	public void afterSetter(JoinPoint jpt) {
		System.out.println("AFTER SETTER :: " + jpt.getSignature());
	}
	
	@Around("execution (* Account.withdraw(..))")
	public Object aroundWithdraw(ProceedingJoinPoint pjpt) throws Throwable {
		// pre
		System.out.println("Before withdraw()");
		//pjpt.getTarget();
		//pjpt.getThis();
		// invoke
		Object res = pjpt.proceed(pjpt.getArgs());
		// post
		System.out.println("After withdraw()");
		return res;
	}
	
	@Pointcut("execution (* Account.withdraw(..)) || execution (* Account.deposit(..))")
	public void transaction() {
		// ...
	}
	
	@AfterThrowing("transaction()")
	public void afterTransactionException(JoinPoint jpt) {
		System.out.println("Exception in withdraw or deposit.");
	}
}
