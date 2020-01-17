package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountImpl {
	private int accId;
	private double balance;
	private String type;
	@Autowired
	private PersonImpl accHolder;
	public AccountImpl() {
		
	}
	public AccountImpl(int accId, double balance, String type) {
		this.accId = accId;
		this.balance = balance;
		this.type = type;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public PersonImpl getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(PersonImpl accHolder) {
		this.accHolder = accHolder;
	}
	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	@Override
	public String toString() {
		return "AccountImpl [accId=" + accId + ", balance=" + balance + ", type=" + type + ", accHolder=" + accHolder
				+ "]";
	}
}
