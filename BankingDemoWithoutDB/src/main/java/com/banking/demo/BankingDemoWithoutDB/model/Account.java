package com.banking.demo.BankingDemoWithoutDB.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer accountNumber;
	private String name;
	private double balance;
	private boolean activeStatus;
	
}
