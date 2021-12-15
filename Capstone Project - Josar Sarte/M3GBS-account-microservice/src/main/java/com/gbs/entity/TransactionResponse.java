package com.gbs.entity;

import java.util.List;

public class TransactionResponse {
	private List<Transaction> transaction;

	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setAccounts(List<Transaction> transaction) {
		this.transaction = transaction;
	}
}
