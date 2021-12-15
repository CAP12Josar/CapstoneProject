package com.gbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	@Column(name = "CREATION_DATE")
	private String creationDate;
	@Column(name = "NUMBER_OF_ACCOUNTS")
	private int numberOfAccounts;
	@Column(name = "LIST_OF_ACCOUNTS")
	private String listOfAccounts;
	@Column(name = "TOTAL_BALANCE")
	private float totalBalance;
	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPassword, String creationDate, int numberOfAccounts, 
			String listOfAccounts, float totalBalance, String contactNumber) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.creationDate = creationDate;
		this.numberOfAccounts = numberOfAccounts;
		this.listOfAccounts = listOfAccounts;
		this.totalBalance = totalBalance;
		this.contactNumber = contactNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}
	public String getListOfAccounts() {
		return listOfAccounts;
	}

	public void setListOfAccounts(String listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

	public float getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(float totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}

