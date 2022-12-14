package com.vishal.springdata.inheritanceMapping.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@DiscriminatorValue("cc")
public class CreditCard extends Payment{

	private String cardnumber;

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String creditCard) {
		this.cardnumber = creditCard;
	}

	
}
