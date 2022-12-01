package com.vishal.springdata.assignmentCustomer;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.GenerationTypeCourse.assignment.entity.Customer;
import com.vishal.springdata.GenerationTypeCourse.assignment.repository.CustomerRepository;

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
	
	@Test
	public void findCustomerBy() {
		Customer customer = customerRepo.findById(839212l).get();
		List<Customer> customerByName = customerRepo.findByName("vishal");
		System.out.println("customer found by id:: "+customer);
		System.out.println("customerByName :: "+customerByName);
	}
}
