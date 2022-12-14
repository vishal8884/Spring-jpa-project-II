package com.vishal.springdata.inheritanceMapping.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
public class Check extends Payment{

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}


	
	
}
