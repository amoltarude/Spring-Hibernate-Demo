package com.sunbeaminfo.sh.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {
	private static final SessionFactory factory = createSessionFactory();
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory createSessionFactory() {
		
		serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
	
		Metadata metadata = new MetadataSources(serviceRegistry)
				.getMetadataBuilder()
				.build();
		
		return metadata.getSessionFactoryBuilder().build();
		
		
//		Configuration conf = new Configuration();
//		conf.configure();
//		return conf.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	public static Session getSession() {
		return factory.openSession();
	}

	public static void shutdown() {
		factory.close();
	}
}
