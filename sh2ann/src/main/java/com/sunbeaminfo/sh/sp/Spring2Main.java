package com.sunbeaminfo.sh.sp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring2Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx
			= new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.registerShutdownHook();

		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		System.out.println("b1 - Volume : " + b1.calcVolume());
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		System.out.println("b2 - Volume : " + b2.calcVolume());

		// ctx.close();
	}
}
