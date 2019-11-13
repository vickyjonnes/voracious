package com.banking.demo.BankingDemo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.banking.demo.BankingDemo.model.Account;

public interface BankRepository extends JpaRepository<Account, Integer> {

	@Query("select a.balance from Account a where a.accountNumber=:accountNumber")
	public double checkBalance(@Param("accountNumber") Integer accountNumber);
	
	@Transactional
	@Modifying
	@Query("update Account a set a.balance=:amount where a.accountNumber=:accountNumber")
	public void setNewBalance(@Param("accountNumber") Integer accountNumber, @Param("amount") double amount);
	
	@Transactional
	@Modifying
	@Query("update Account a set a.activeStatus=false where a.accountNumber=:accountNumber")
	public void deactivateAccount(@Param("accountNumber") Integer accountNumber);
	
	@Query("select a from Account a where a.activeStatus=true")
	public List<Account> getActiveAccounts();
	
	@Query("select a from Account a")
	public List<Account> getAllAccounts();
}
