package com.gbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.TransactionalRepositoryFactoryBeanSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbs.entity.Transaction;
import com.gbs.repository.TransactionRepository;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping("/TransactionLog")
	public List<Transaction> getAllTransaction(){
		List<Transaction> transactionList = transactionRepository.findAll();
		return transactionList;
	}
	
	@PostMapping("/transactionSave")
	public Transaction savedTransaction(@RequestBody Transaction transactionFromClientTransaction) {
		Transaction savedTransaction = transactionRepository.save(transactionFromClientTransaction);
		return savedTransaction;
		
	}
	@PostMapping("/TransactionDetails")
	public Transaction createTransaction(@RequestBody Transaction transactionFromBrowser) {
		Transaction savedTransaction = transactionRepository.save(transactionFromBrowser);
		return savedTransaction;
	}
	
}
