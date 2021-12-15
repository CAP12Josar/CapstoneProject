package com.gbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber;
	@Column(name="USER_NAME")
	private String userName;
	@Column (name="ACCOUNT_BALANCE")
	private Double accountBalance;
	
	public Account() {
		super();
	
	}
	public Account(String userName, String accountNumber, Double accountBalance) {
		super();
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserNameString(String userName) {
		this.userName = userName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
}
