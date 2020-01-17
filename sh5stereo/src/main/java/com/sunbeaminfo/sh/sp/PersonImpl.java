package com.sunbeaminfo.sh.sp;

import org.springframework.stereotype.Component;

@Component
public class PersonImpl {
	private String name;
	private int age;
	private String mobile;
	public PersonImpl() {
	
	}
	public PersonImpl(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}
}
