package com.eight.clinicals.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eight.clinicals.dto.ClinicalDataRequest;
import com.eight.clinicals.entities.ClinicalData;
import com.eight.clinicals.entities.Patient;
import com.eight.clinicals.repository.ClinicalRepository;
import com.eight.clinicals.repository.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {

	@Autowired
	private ClinicalRepository clinicalRepo;
	
	@Autowired
	private PatientRepository paientRepo;
	
	Map<String, String> filters = new HashMap<>();
	
	/*
	 * not working need to debug
	 */
	@PostMapping("/clinicals")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
	    Patient patient = paientRepo.findById(request.getPatientId()).orElse(new Patient());

	    ClinicalData clinicalData = new ClinicalData();
	    
	    clinicalData.setComponentName(request.getComponentName());
	    clinicalData.setComponentValue(request.getComponentValue());
	    clinicalData.setPatient(patient);
	    
	    return clinicalRepo.save(clinicalData);
	}
	
	@GetMapping("/patients/analyze/{id}")
	public Patient analyze(@PathVariable int id) {
		Patient patient = paientRepo.findById(id).get();
		List<ClinicalData> clinicalData = patient.getClinicalData();
		ArrayList<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
		
		for(ClinicalData eachEntry : duplicateClinicalData) {
			
			//One person can have only one component thats why this filter logic is added
			if(filters.containsKey(eachEntry.getComponentName())) { //filter duplicates
				clinicalData.remove(eachEntry);
				continue;
			}
			else {
				filters.put(eachEntry.getComponentName(), null);
			}
			
			if(eachEntry.getComponentName().equals("hw")) {
				String[] heightAndWeight = eachEntry.getComponentValue().split("/");
				
				if(heightAndWeight != null && heightAndWeight.length>1) {
				
				    float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536f;
				    float bmi = Float.parseFloat(heightAndWeight[1])/(heightInMeters*heightInMeters);
				
			    	ClinicalData bmiData = new ClinicalData();  //Bmi data we dont store in table its just returned
			    	bmiData.setComponentName("bmi");
			    	bmiData.setComponentValue(Float.toString(bmi));
				
				    
			    	clinicalData.add(bmiData);
				}
			}
		}
		
		filters.clear();
		return patient;
	}
}
