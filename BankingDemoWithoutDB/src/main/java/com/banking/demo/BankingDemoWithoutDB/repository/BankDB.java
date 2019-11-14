package com.banking.demo.BankingDemoWithoutDB.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.banking.demo.BankingDemoWithoutDB.model.Account;

@Repository
public class BankDB implements BankRepository{

	final Map<Integer, Account> map=new ConcurrentHashMap<>();
	@Override
	public double checkBalance(Integer accountNumber) {
		if(Objects.nonNull(map.get(accountNumber)))
			return map.get(accountNumber).getBalance();
		return 0.0;
	}

	@Override
	public void setNewBalance(Integer accountNumber, double amount) {
		if(Objects.nonNull(map.get(accountNumber)))
			map.get(accountNumber).setBalance(amount);
	}

	@Override
	public void deactivateAccount(Integer accountNumber) {
		if(Objects.nonNull(map.get(accountNumber)))
			map.get(accountNumber).setActiveStatus(false);
	}

	@Override
	public List<Account> getActiveAccounts() {
		return map.values().stream().filter(a->a.isActiveStatus()).collect(Collectors.toList());
	}

	@Override
	public List<Account> getAllAccounts() {
		return map.values().stream().collect(Collectors.toList());
	}

	@Override
	public boolean createAccount(Account acc) {
		return map.putIfAbsent(acc.getAccountNumber(), acc)==null?true:false;
	}

	@Override
	public Account findAccountById(Integer accountNumber) {
		return map.get(accountNumber);
	}

}
