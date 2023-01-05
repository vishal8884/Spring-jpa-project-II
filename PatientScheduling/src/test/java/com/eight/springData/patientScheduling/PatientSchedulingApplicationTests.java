package com.eight.springData.patientScheduling;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eight.springData.patientScheduling.entities.Appointment;
import com.eight.springData.patientScheduling.entities.Doctor;
import com.eight.springData.patientScheduling.entities.Insurance;
import com.eight.springData.patientScheduling.entities.Patient;
import com.eight.springData.patientScheduling.repositories.AppointmentRepositrory;
import com.eight.springData.patientScheduling.repositories.DoctorRepository;
import com.eight.springData.patientScheduling.repositories.PatientRepository;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	AppointmentRepositrory appointmentRepo;

	@Test
	public void testCreateDoctor() {

		Doctor doctor = Doctor.builder()
				.id(1l)
				.firstName("vishal")
				.lastName("N")
				.speciality("All")
				.build();

		doctorRepository.save(doctor);
	}
	
	@Test
	public void testCreatePatient() {
		Patient patient = Patient.builder()
				  .firstName("xoro")
				  .lastName("water")
				  .phone("5682392343")
				  .insurance(Insurance.builder().providerName("LIC").copay(20).build())
				  .build();
		
		Doctor doctor = doctorRepository.findById(1l).get();
		List<Doctor> doctors = List.of(doctor);
		
		patient.setDoctors(doctors);
		
		patientRepository.save(patient);
	}
	
	@Test
	public void testCreateAppointment() {
		Appointment appointment = Appointment.builder()
				.id(1l)
				.appointmentTime(new Timestamp(new Date().getTime()))
				.reason("fever")
				.started(true)
				.patient(patientRepository.findById(1l).get())
				.doctor(doctorRepository.findById(1l).get())
				.build();
		
		appointmentRepo.save(appointment);
	}

}
