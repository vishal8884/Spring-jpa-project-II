package com.eight.clinicals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eight.clinicals.entities.Patient;
import com.eight.clinicals.repository.patientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {

	private patientRepository patientRepo;
	
	@Autowired
    public PatientController(patientRepository patientRepo) {
    	this.patientRepo = patientRepo;
	}
	
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public List<Patient> getPatients(){
		return patientRepo.findAll();
	}
	
	@GetMapping("/patients/{id}")
	public Patient getPatient(@PathVariable(value = "id") int id) {
		return patientRepo.findById(id).get();
	}
	
	@PostMapping("/patients")
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
}
