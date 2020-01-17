package com.sunbeaminfo.sh.sp;

import org.springframework.stereotype.Component;

@Component("p1")
public class PersonImpl implements Person {
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
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int getAge() {
		return age;
	}
	@Override
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String getMobile() {
		return mobile;
	}
	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}
}
