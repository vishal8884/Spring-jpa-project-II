package com.vishal.springdata.GenerationTypeCourse.entities;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity
public class Employee {

	//@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100) //seperate table will be created for this
	@Id
	@GenericGenerator(name = "emp_id",strategy = "com.vishal.springdata.GenerationTypeCourse.utils.CustomRandomIdGenerators")
	@GeneratedValue(generator = "emp_id")
	//@GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_gen")
	private long id;
	private String name;

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

}
