package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Spring4Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		int vol2 = b2.calcVolume();
		System.out.println("b2 - Volume : " + vol2);
		
	}
}
