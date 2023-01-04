package com.eight.springData.patientScheduling;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eight.springData.patientScheduling.entities.Doctor;
import com.eight.springData.patientScheduling.repositories.DoctorRepository;

@SpringBootTest
class PatientSchedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

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

}
