package com.eight.transactionManagement.services;

import com.eight.transactionManagement.entities.BankAccount;

public interface BankAccountService {

	void tranfer(int amount);
	
	BankAccount addData(BankAccount bankAccount);
}
