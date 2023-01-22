package com.eight.springData.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@IdClass(CustomerId.class)
@Table(name = "CompositeCustomer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private int id;
	@Id
	private String email;
	private String customer;
	private String name;
	
}
