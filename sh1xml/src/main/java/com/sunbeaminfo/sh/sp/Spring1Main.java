package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Spring1Main {
	public static void main(String[] args) {
		/*
		BoxImpl b1 = new BoxImpl();
		b1.setLength(10);
		b1.setBreadth(8);
		b1.setHeight(6);
		System.out.println("b1 - Volume : " + b1.calcVolume());
		
		BoxImpl b2 = new BoxImpl(5, 4, 3);
		System.out.println("b2 - Volume : " + b2.calcVolume());
		*/
		
		/*
		Resource res = new ClassPathResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res );
		
		BoxImpl b1 = (BoxImpl) factory.getBean("b1");
		System.out.println("b1 - Volume : " + b1.calcVolume());
		
		BoxImpl b2 = (BoxImpl) factory.getBean("b2");
		System.out.println("b2 - Volume : " + b2.calcVolume());
		*/
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		ctx.registerShutdownHook();
		//Runtime.getRuntime().addShutdownHook(...);
		
		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		System.out.println("b1 - Volume : " + b1.calcVolume());
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		System.out.println("b2 - Volume : " + b2.calcVolume());
		
		//ctx.close();
	}
}
