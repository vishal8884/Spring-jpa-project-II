package com.vishal.springdata.product.assignments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.GenerationTypeCourse.assignment.entity.Customer;
import com.vishal.springdata.GenerationTypeCourse.assignment.entity.CustomerRepository;

@SpringBootTest
public class CustomerTest {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Test
	public void createCustomerTable() {
		Customer customer1 = new Customer();
		customer1.setName("vishal");
		
		customerRepo.save(customer1);
	}
}
