package com.vishal.springdata.componentMapping.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Education {

	private String degree;
	private String percentage;
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public Education(String degree, String percentage) {
		super();
		this.degree = degree;
		this.percentage = percentage;
	}
	
	
	public Education() {
		
	}
}
