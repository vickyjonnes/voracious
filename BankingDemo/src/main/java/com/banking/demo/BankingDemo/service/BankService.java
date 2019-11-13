package com.banking.demo.BankingDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.BankingDemo.model.Account;
import com.banking.demo.BankingDemo.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepository;
	
	public boolean createAccount(Account acc) {
		return bankRepository.save(acc) !=null ? true:false;
	}
	
	public String checkBalance(int accountNumber) {
		return String.valueOf(bankRepository.checkBalance(accountNumber));
	}
	
	public String withdrawAmount(int accountNumber, double amount) {
		double currentBalance=bankRepository.checkBalance(accountNumber);
		if(currentBalance<amount) {
			return "Account do not have enough balance: "+currentBalance;
		}
		bankRepository.setNewBalance(accountNumber, currentBalance-amount);
		currentBalance=bankRepository.checkBalance(accountNumber);
		return "Available Balance is: "+currentBalance;
	}
	
	
	public String depositAmount(int accountNumber, double amount) {
		double currentBalance=bankRepository.checkBalance(accountNumber);
		bankRepository.setNewBalance(accountNumber, currentBalance+amount);
		currentBalance=bankRepository.checkBalance(accountNumber);
		return "Available Balance is: "+currentBalance;
	}
	
	public String deactivateAccount(int accountNumber) {
		bankRepository.deactivateAccount(accountNumber);
		return "account deactivated successfully";
	}
	
	public List<Account> getAllAccounts(){
		return bankRepository.getAllAccounts();
	}
	
	public List<Account> getActiveAccounts(){
		return bankRepository.getActiveAccounts();
	}
	
	public Account getAccountByNumber(Integer accountNumber) {
		return bankRepository.findById(accountNumber).get();
	}
}
