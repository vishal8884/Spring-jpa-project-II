package com.vishal.springdata.GenerationTypeCourse.repos;

import org.springframework.data.repository.CrudRepository;

import com.vishal.springdata.GenerationTypeCourse.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
