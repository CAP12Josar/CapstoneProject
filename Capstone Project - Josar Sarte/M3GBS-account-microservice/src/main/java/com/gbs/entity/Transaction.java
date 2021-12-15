package com.gbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTIONS")
public class Transaction {
	
	
	@Id
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	@Column(name="FROM_ACCOUNT")
	private String fromAccount;
	@Column(name="TO_ACCOUNT")
	private String toAccount;
	@Column(name="ACCOUNT_BALANCE")
	private double accountBalance;
	
	public Transaction() {
		super();
		
	}
	public Transaction(String transactionId, String fromAccount, String toAccount, double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.accountBalance = accountBalance;
	}
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double amount) {
		this.accountBalance = amount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", accountBalance=" + accountBalance + "]";
	}

	
}
