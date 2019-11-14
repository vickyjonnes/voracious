package com.banking.demo.BankingDemoWithoutDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.demo.BankingDemoWithoutDB.model.Account;
import com.banking.demo.BankingDemoWithoutDB.model.Transaction;
import com.banking.demo.BankingDemoWithoutDB.service.BankService;

@RestController
@RequestMapping(path="/bank", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class BankController {

	@Autowired
	BankService bankService;
	
	@PutMapping(path="/create-account")
	public String createAccount(@RequestBody Account account){
		account.setActiveStatus(true);
		if(bankService.getAccountByNumber(account.getAccountNumber())!=null) {
			return "account number already present";
		}
		boolean status=bankService.createAccount(account);
		if(status)
			return "account created succeffully";
		return "some problem occured";
	}
	
	@GetMapping(path="/balance/{accountNumber}")
	public String checkBalance(@PathVariable int accountNumber){
		return bankService.checkBalance(accountNumber);
	}
	
	@PostMapping(path="/transaction")
	public String creditDebitBalance(@RequestBody Transaction txn){
		if(txn.getCreditDebitInd().equals("withdraw")) {
			return bankService.withdrawAmount(txn.getAccountNumber(), txn.getAmount());
		}else {
			return bankService.depositAmount(txn.getAccountNumber(), txn.getAmount());
		}
	}
	
	@PostMapping(path="/disableAccount/{accountNumber}")
	public String deactivateAccount(@PathVariable int accountNumber){
		return bankService.deactivateAccount(accountNumber);
	}
	
	@GetMapping(path="/listAccounts")
	public List<Account> getAllAccounts(){
		return bankService.getAllAccounts();
	}
	
	@GetMapping(path="/listActiveAccounts")
	public List<Account> getActiveAccounts(){
		return bankService.getActiveAccounts();
	}
	
}
