package com.vishal.springdata.inheritanceMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.springdata.inheritanceMapping.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
