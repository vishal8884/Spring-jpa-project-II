package com.vishal.springdata.studentJpqlAndNativeQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.StudentForJpql.repository.StudentRepository;

@SpringBootTest
public class NativeQueryTests {

	@Autowired
	StudentRepository repo;
	
	@Test
	public void testAllStudentNQ() {
		System.out.println("find all students "+repo.findAllStudentsNQ());
	}
	
	@Test
	public void testFindByFirstNameNQ() {
		System.out.println("find by first name "+repo.findByFirstNameNQ("vishal"));
	}
}
