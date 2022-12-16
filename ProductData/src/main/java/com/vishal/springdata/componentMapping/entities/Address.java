package com.vishal.springdata.componentMapping.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

	
	private String streetaddress;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetAddress) {
		this.streetaddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Address(String streetaddress, String city, String state, String zipcode, String country) {
		this.streetaddress = streetaddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	
	public Address() {
		
	}
	
	
}
