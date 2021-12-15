package com.gbs.stub;

import java.util.List;

import gom.gbs.model.Transaction;

public class TransactionResponse {
	private List<Transaction> transaction;

	public List<Transaction> getTransaction() {
		return transaction;
	}
	public void setAccounts(List<Transaction> transaction) {
		this.transaction = transaction;
	}
}
