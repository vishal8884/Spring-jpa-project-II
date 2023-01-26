package com.eight.clinicals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalDataRequest {

	private String componentName;
	private String componentValue;
	private int patientId;
}
