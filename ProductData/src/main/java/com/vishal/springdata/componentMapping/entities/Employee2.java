package com.vishal.springdata.componentMapping.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee2 {

	@Id
	private int id;
	private String name;
	
	@Embedded
	private Address address;
	
	@Embedded
	private Education education;
	
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	public Employee2(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Employee2() {
	}
	
	
}
