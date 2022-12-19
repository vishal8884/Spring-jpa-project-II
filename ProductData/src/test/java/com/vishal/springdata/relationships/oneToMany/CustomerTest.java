package com.vishal.springdata.relationships.oneToMany;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
		customer.setName("john2");
		
		//HashSet<PhoneNumber> numbers = new HashSet<>();
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("7834758585");
		ph1.setType("cell");
		//ph1.setCustomer(customer);
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("7834758583");
		ph2.setType("cell");
		//ph2.setCustomer(customer);
		
		//numbers.add(ph1);
		//numbers.add(ph2);
		
		//customer.setNumbers(numbers);
		
		customer.addPhoneNumber(ph1);
		customer.addPhoneNumber(ph2);
		
		repo.save(customer);
	}
	
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Customer2 customer = repo.findById(102L).get();
		System.out.println("customer name :: "+customer.getName());
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> System.out.println("customer ph number :: "+n.getNumber()));
	}
	
	
	@Test
	public void testUpdateCustomer() {
		Customer2 customer = repo.findById(102L).get();
		customer.setName("waters");
		
		Set<PhoneNumber> numbers = customer.getNumbers();
		numbers.forEach(n -> n.setType("home"));
		
		Customer2 saved = repo.save(customer);
		System.out.println("saved customer :: "+saved.getId()+"    name :: "+saved.getName());
	}
	
	@Test
	public void testDelete() {
		repo.deleteById(202L);
	}
	
	
	
	
}


/*
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

*/