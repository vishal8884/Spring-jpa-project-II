package com.vishal.springdata.relationships.oneToOne;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.relationships.oneToOne.entities.License;
import com.vishal.springdata.relationships.oneToOne.entities.Person;
import com.vishal.springdata.relationships.oneToOne.repository.LicenseRepository;

@SpringBootTest
public class OneToOneTest {

	@Autowired
	private LicenseRepository repo;
	
	@Test
	public void testOneToOneCreateLicence() {
		License license = new License();
		
		Person person = new Person();
		person.setFirstName("john");
		person.setLastName("waters");
		person.setAge(22);
		
		license.setType("car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		license.setPerson(person);
		
		repo.save(license);
	}
}
