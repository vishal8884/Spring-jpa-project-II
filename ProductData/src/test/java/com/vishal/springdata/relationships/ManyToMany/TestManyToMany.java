package com.vishal.springdata.relationships.ManyToMany;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishal.springdata.relationships.ManyToMany.entities.Programmer;
import com.vishal.springdata.relationships.ManyToMany.entities.Project;
import com.vishal.springdata.relationships.ManyToMany.repository.ProgrammerRepository;

@SpringBootTest
public class TestManyToMany {

	@Autowired
	ProgrammerRepository repo;
	
	@Test
	public void testManyToManyCreateProgrammer() {
		Programmer programmer = new Programmer();
		
		Set<Project> projects =  new HashSet<>();
		Project project = new Project();
		project.setName("hibernate");
		projects.add(project);
		
		programmer.setName("Vishal");
		programmer.setSalary(1000);
		programmer.setProjects(projects);
		
		repo.save(programmer);
	}
	
	@Test
	public void testManyToManyFindProgrammer() {
		Programmer programmer = repo.findById(1).get();
		System.out.println("programmer :: "+programmer);
		System.out.println("projects by programmer :: "+programmer.getProjects());
	}
}
