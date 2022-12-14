package com.vishal.springdata.inheritanceMapping.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@DiscriminatorValue("ch")
@Table(name = "bankcheck")
public class Check extends Payment{

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

    public void setChecknumber(String checknumber) {
    	this.checknumber = checknumber;
    }
	
	
}
