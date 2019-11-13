package com.banking.demo.BankingDemo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer accountNumber;
	private String name;
	private double balance;
	private boolean activeStatus;
	
}
