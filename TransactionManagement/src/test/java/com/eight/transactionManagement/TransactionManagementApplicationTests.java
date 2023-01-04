package com.eight.transactionManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eight.transactionManagement.entities.BankAccount;
import com.eight.transactionManagement.services.BankAccountService;

@SpringBootTest
class TransactionManagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	//@Test
	public void addData() {
		BankAccount ba = new BankAccount();
		ba.setAccno(2);
		ba.setFirstName("trump");
		ba.setLastName("L");
		ba.setBal(70000);
		
		service.addData(ba);
	}
	
	/*
	 * Run time exception will happen from service layer
	 */
	@Test
	public void testTransfer() {
		service.tranfer(500);
	}

}
