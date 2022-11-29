package com.vishal.springdata.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.GenerationTypeCourse.entities.Employee;
import com.vishal.springdata.GenerationTypeCourse.repos.EmployeeRepository;

@SpringBootTest
public class TestCreateEmployee {

	@Autowired
	private EmployeeRepository repo;
	
	
	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("john4");
		
		repo.save(employee);
	}
}
