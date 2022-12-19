package com.vishal.springdata.relationships.oneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.springdata.relationships.oneToMany.entities.Customer2;


public interface CustomerRepository2 extends JpaRepository<Customer2, Long>{

}
