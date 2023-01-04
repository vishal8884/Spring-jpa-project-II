package com.eight.springData.patientScheduling.repositories;

import org.springframework.data.repository.CrudRepository;

import com.eight.springData.patientScheduling.entities.Appointment;

public interface AppointmentRepositrory extends CrudRepository<Appointment, Long>{

}
