package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("a1")
public class AccountImpl implements Account {
	private int accId;
	private double balance;
	private String type;
	//@Autowired
	@Value("#{p1}")
	private Person accHolder;
	public AccountImpl() {
		
	}
	public AccountImpl(int accId, double balance, String type) {
		this.accId = accId;
		this.balance = balance;
		this.type = type;
	}
	@Override
	public int getAccId() {
		return accId;
	}
	@Override
	public void setAccId(int accId) {
		this.accId = accId;
	}
	@Override
	public double getBalance() {
		return balance;
	}
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public Person getAccHolder() {
		return accHolder;
	}
	@Override
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	@Override
	public void deposit(double amount) {
		this.balance += amount;
	}
	@Override
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	@Override
	public String toString() {
		return "AccountImpl [accId=" + accId + ", balance=" + balance + ", type=" + type + ", accHolder=" + accHolder
				+ "]";
	}
}
