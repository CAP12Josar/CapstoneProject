package com.gbs.stub;


import java.util.List;

import gom.gbs.model.Account;

public class AccountResponse {
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
