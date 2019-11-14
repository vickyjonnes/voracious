package com.banking.demo.BankingDemoWithoutDB.repository;

import java.util.List;

import com.banking.demo.BankingDemoWithoutDB.model.Account;

public interface BankRepository {

	public double checkBalance(Integer accountNumber);
	
	public void setNewBalance(Integer accountNumber, double amount);
	
	public void deactivateAccount(Integer accountNumber);
	
	public List<Account> getActiveAccounts();
	
	public List<Account> getAllAccounts();
	
	public boolean createAccount(Account acc);
	
	public Account findAccountById(Integer accountNumber);
}
