package com.eight.springData.patientScheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eight.springData.patientScheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{

}
