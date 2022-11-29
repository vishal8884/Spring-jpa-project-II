package com.vishal.springdata.GenerationTypeCourse.assignment.repository;

import org.springframework.data.repository.CrudRepository;

import com.vishal.springdata.GenerationTypeCourse.assignment.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
