package com.vishal.springdata.relationships.oneToMany.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	private Set<PhoneNumber> numbers;
	
	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer2(long id, String name, Set<PhoneNumber> numbers) {
		super();
		this.id = id;
		this.name = name;
		this.numbers = numbers;
	}
	
	public Customer2() {
		
	}
	
}
