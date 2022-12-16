package com.vishal.springdata.componentMapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.componentMapping.entities.Address;
import com.vishal.springdata.componentMapping.entities.Education;
import com.vishal.springdata.componentMapping.entities.Employee2;
import com.vishal.springdata.componentMapping.repos.EmployeeRepository2;

@SpringBootTest
public class EmployeeTest {

	@Autowired
	private EmployeeRepository2 repo;
	
	@Test
	public void testCreate() {
		Employee2 employee = new Employee2();
		employee.setId(123);
		employee.setName("vishal");
		employee.setAddress(new Address("450", "bangalore","karnataka", "534222", "India"));
		employee.setEducation(new Education("B tech", "88"));
		
		repo.save(employee);
	}
}
