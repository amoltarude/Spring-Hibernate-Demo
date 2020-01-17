package com.sunbeaminfo.sh.sp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(initMethod="boxInit", destroyMethod="boxDestroy")
	public BoxImpl b1() {
		BoxImpl b = new BoxImpl();
		b.setLength(10);
		b.setBreadth(8);
		b.setHeight(6);
		return b;
	}
	@Bean
	public BoxImpl b2() {
		BoxImpl b = new BoxImpl(5, 4, 3);
		return b;
	}
}
