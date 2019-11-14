package com.banking.demo.BankingDemoWithoutDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/properties/application.properties")
@SpringBootApplication
public class BankingDemoWithoutDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingDemoWithoutDbApplication.class, args);
	}

}
