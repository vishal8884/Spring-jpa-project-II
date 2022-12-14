package com.vishal.springdata.inheritanceMapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.inheritanceMapping.entities.Check;
import com.vishal.springdata.inheritanceMapping.entities.CreditCard;
import com.vishal.springdata.inheritanceMapping.repository.PaymentRepository;

@SpringBootTest
public class InheritanceMappingTest {
	
	@Autowired
	PaymentRepository repo;

	@Test
	public void createPayment() {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(123);
		creditCard.setAmount(1000);
		creditCard.setCardnumber("123456789");
		
		repo.save(creditCard);
	}
	
	@Test
	public void createCheckPayment() {
		Check ch = new Check();
		ch.setId(124);
		ch.setAmount(1000);
		ch.setChecknumber("12324345");
		
		repo.save(ch);
	}
	
}
