package com.eight.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.springData.entities.Customer;
import com.eight.springData.entities.CustomerId;

public interface CustomerRepo extends JpaRepository<Customer,CustomerId>{

}
