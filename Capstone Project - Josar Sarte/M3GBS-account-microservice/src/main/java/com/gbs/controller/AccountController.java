package com.gbs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.Account;
import com.gbs.entity.AccountResponse;
import com.gbs.repository.AccountsRepository;


@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountsRepository accountsRepository;
	
	@GetMapping("/accountsResponse")
	public AccountResponse getAllAccountResponse() {
		List<Account> accountList = accountsRepository.findAll();
		AccountResponse accountResponse = new AccountResponse();
		accountResponse.setAccounts(accountList);
		return accountResponse;
	}
	
	@PutMapping("/account/{accountNumber}")
	public Account updateAccount(@PathVariable(value = "accountNumber") String accountNumber,
			@RequestBody Account accountFromBrowser) {
		Account existingAccount = accountsRepository.findById(accountNumber).get();
		existingAccount.setAccountBalance(accountFromBrowser.getAccountBalance());
		existingAccount.setUserNameString(accountFromBrowser.getUserName());
		Account updateAccount = accountsRepository.save(existingAccount);

		return updateAccount;
	}
//	@GetMapping("accounts")
//	public List<Account> getAllAccounts(){
//		List<Account> accountList = accountsRepository.findAll();
//		return accountList;
//	}

}
