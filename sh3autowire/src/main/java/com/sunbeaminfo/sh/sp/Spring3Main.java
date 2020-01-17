package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Spring3Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		
		
		Box b1 = (Box) ctx.getBean("b1");
		int vol1 = b1.calcVolume();
		System.out.println("b1 - Volume : " + vol1);
		
//		
//		Box b2 = (Box) ctx.getBean("b2");
//		int vol2 = b2.calcVolume();
//		System.out.println("b2 - Volume : " + vol2);
		
	}
}
