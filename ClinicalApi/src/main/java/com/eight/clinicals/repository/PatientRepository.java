package com.eight.clinicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.clinicals.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
