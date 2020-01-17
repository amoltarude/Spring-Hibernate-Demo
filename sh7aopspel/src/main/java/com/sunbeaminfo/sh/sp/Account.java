package com.sunbeaminfo.sh.sp;

public interface Account {

	int getAccId();

	void setAccId(int accId);

	double getBalance();

	void setBalance(double balance);

	String getType();

	void setType(String type);

	Person getAccHolder();

	void setAccHolder(Person accHolder);

	void deposit(double amount);

	void withdraw(double amount);

}