package com.vishal.springdata.studentJpql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.vishal.springdata.StudentForJpql.entities.Student;
import com.vishal.springdata.StudentForJpql.repository.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class StudentJpqlTests {

	@Autowired
	private StudentRepository repo;
	
	@Test
	public void testStudentCreate() {
		repo.save(new Student("jb","waters",91));
	}
	
	@Test
	public void testFindAllStudents() {
		System.out.println("all students :: "+repo.findAllStudents());
	}
	
	@Test
	public void testFindAllStudentsPartial() {
		List<Object[]> partialData = repo.findAllStudentsPartialData();
		for(Object[] objects : partialData) {
			System.out.println("partial data firstName :: "+objects[0]);
			System.out.println("partial data lastName  :: "+objects[1]);
		}
	}
	
	@Test
	public void testFindStudentsByFirstName() {
		System.out.println("all students by firstName:: "+repo.findAllStudentsByFirstName("priya"));
	}
	
	@Test
	public void testFindAllStudentsBetweenScore() {
		System.out.println("all students between scores :: "+repo.findAllStudentsBetweenScore(30, 90));
	}
	
	@Test
	@Transactional  //mark this along with @Modifying in repo to update/delete use jqpl or native query
	@Rollback(false)  //used only in test class...in normal class not required
	public void testDeleteStudentsByFirstName() {
		repo.deleteStudentsByFirstName("priya");
	}
}
