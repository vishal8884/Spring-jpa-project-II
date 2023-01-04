package com.eight.springData.patientScheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eight.springData.patientScheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long>{

}
