package com.vishal.springdata.inheritanceMapping.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)           
//@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)   // need this for single stratagy only..as we have seperate table now
public abstract class Payment {

	@Id
	private int id;
	private double amount;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
