package com.vishal.springdata.relationships.oneToMany;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.relationships.oneToMany.entities.Customer2;
import com.vishal.springdata.relationships.oneToMany.entities.PhoneNumber;
import com.vishal.springdata.relationships.oneToMany.repository.CustomerRepository2;

@SpringBootTest
public class CustomerTest {

	@Autowired
	CustomerRepository2 repo;
	
	@Test
	public void testCreateCustomer() {
		Customer2 customer = new Customer2();
		customer.setName("john");
		
		HashSet<PhoneNumber> numbers = new HashSet<>();
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("7834758585");
		ph1.setType("cell");
		ph1.setCustomer(customer);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("7834758583");
		ph2.setType("cell");
		ph2.setCustomer(customer);
		
		numbers.add(ph1);
		numbers.add(ph2);
		
		customer.setNumbers(numbers);
		
		repo.save(customer);
	}
}
