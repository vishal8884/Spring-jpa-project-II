package com.eight.clinicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.clinicals.entities.Patient;

public interface patientRepository extends JpaRepository<Patient, Integer>{

}
