package com.eight.springData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eight.springData.entities.Customer;
import com.eight.springData.repository.CustomerRepo;

@SpringBootTest
class CompositeKeyApplicationTests {
	
	@Autowired
	CustomerRepo repo;

	@Test
	public void testSaveCustomer() {
		Customer saved = repo.save(Customer.builder().id(1234).email("vishal@gmail.com").name("vishal").build());
		System.out.println("savedCustomer :: "+saved);

	}
}
