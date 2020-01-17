package com.sunbeaminfo.sh.sp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ai1")
public class AccountInfoImpl {
	@Value("#{a1.accId}")
	private int accId;
	@Value("#{a1.accHolder.name}")
	private String accHolderName;
	
	public AccountInfoImpl() {
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	@Override
	public String toString() {
		return "AccountInfoImpl [accId=" + accId + ", accHolderName=" + accHolderName + "]";
	}
}
