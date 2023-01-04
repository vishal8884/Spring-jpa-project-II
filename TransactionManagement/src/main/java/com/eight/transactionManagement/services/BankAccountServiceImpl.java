package com.eight.transactionManagement.services;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eight.transactionManagement.entities.BankAccount;
import com.eight.transactionManagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	BankAccountRepository bankRepo;
	
	/*
	 * when we mark @Tranactional...
	 * if exception occurs it rolls back
	 * its like full method is executed or none
	 */
	@Override
	@Transactional
	public void tranfer(int amount) {
		BankAccount obamaAccount = bankRepo.findById(1).get();
		obamaAccount.setBal(obamaAccount.getBal() - amount);
		bankRepo.save(obamaAccount);
		
		if(true) {
		    throw new RuntimeException();
		}
		//if exception after this...there will be issues..it will get deducted from obamas account but not credited to trump account
		
		BankAccount trumpAccount = bankRepo.findById(2).get();
		trumpAccount.setBal(trumpAccount.getBal() + amount);
		bankRepo.save(trumpAccount);
	}

	@Override
	public BankAccount addData(BankAccount bankAccount) {
		return bankRepo.save(bankAccount);
	}

}
