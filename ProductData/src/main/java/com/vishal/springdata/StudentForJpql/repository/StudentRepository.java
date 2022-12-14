package com.vishal.springdata.StudentForJpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vishal.springdata.StudentForJpql.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	//Jpql
	@Query("from Student")
	List<Student> findAllStudents();
	
	@Query("select st.firstName,st.lastName from Student st")   //st is alieas
	List<Object[]> findAllStudentsPartialData();
	
	@Query("from Student where firstName=:fName")
	List<Student> findAllStudentsByFirstName(@Param("fName") String firstName);
	
	@Query("from Student where score >= :score1 and score <= :score2")
	List<Student> findAllStudentsBetweenScore(@Param("score1") int score1,@Param("score2") int score2);
	
	@Modifying //use this while non select operation
	@Query("delete from Student where firstName = :firstName")
	void deleteStudentsByFirstName(@Param("firstName") String firstName);
	
	@Modifying
	@Query("update Student ")
	List<Student> updateStudentById(long id,Student student);
}
